package ru.volnenko.plugin.arch.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.github.hemantsonu20.json.JsonMerge;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;
import ru.volnenko.plugin.arch.model.impl.*;
import ru.volnenko.plugin.arch.model.impl.Queue;
import ru.volnenko.plugin.arch.model.impl.System;
import ru.volnenko.plugin.arch.model.impl.MavenDependencyDto;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;
import ru.volnenko.plugin.arch.util.MapperUtil;

import java.io.File;
import java.util.*;

public final class MavenProjectBuilder {

    @NonNull
    private Settings settings;

    private YAMLMapper yamlMapper = new YAMLMapper();

    @NonNull
    private static Map<String, Class> MAP = new LinkedHashMap<>();

    @NonNull
    private static Map<String, String> PLURALS = new LinkedHashMap<>();

    static {
        registry(ArchApi.class, "archapi");
        registry(Balancer.class, "balancers");
        registry(Database.class, "databases");
        registry(Service.class, "services");
        registry(System.class, "systems");
        registry(Vocabulary.class, "vocabularies");
        registry(User.class, "users");
        registry(Queue.class, "queues");
        registry(Environment.class, "environments");
    }

    public MavenProjectBuilder(@NonNull Settings settings) {
        this.settings = settings;
    }

    private static <T extends MavenProjectDto> void registry(final Class<T> clazz, final String plural) {
        MAP.put(clazz.getSimpleName(), clazz);
        PLURALS.put(clazz.getSimpleName(), plural);
    }

    public static boolean support(@NonNull final String name) {
        return MAP.containsKey(name);
    }

    @NonNull
    private static String plural(@NonNull final String name) {
        return PLURALS.get(name);
    }

    @NonNull
    private Map<String, Object> component(@NonNull MavenProject mavenProject) {
        @NonNull final Map<String, Object> component = new LinkedHashMap<>();
        component.put("groupId", mavenProject.getGroupId());
        component.put("artifactId", mavenProject.getArtifactId());
        component.put("name", mavenProject.getName());
        component.put("url", mavenProject.getUrl());
        component.put("version", mavenProject.getVersion());
        component.put("packaging", mavenProject.getPackaging());
        component.put("description", mavenProject.getDescription());
        component.put("properties", mavenProject.getProperties());
        component.put("dependencies", dep(mavenProject.getDependencies()));

        @NonNull final Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put(mavenProject.getGroupId() + ":" +mavenProject.getArtifactId(), component);
        return wrapper;
    }

    public List<MavenDependencyDto> dep(List<Dependency> dependencies) {
        final List<MavenDependencyDto> result = new ArrayList<>();
        for (Dependency dependency : dependencies) {
            result.add(new MavenDependencyDto(dependency));
        }
        return result;
    }

    @NonNull
    @SneakyThrows
    public <T extends MavenProjectDto> JsonNode getDependencyComponents(
            Set<DefaultArtifact> dependencyArtifacts
    ) {
        List<String> files = new ArrayList<>();
        for (final Object dependencyObject: dependencyArtifacts) {
            if (dependencyObject == null) continue;

            @NonNull final DefaultArtifact dependency = (DefaultArtifact) dependencyObject;
//            final String plural = plural(dependency.getType());
//            if (!result.containsKey(plural)) result.put(plural, new LinkedHashMap<>());
//            LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) result.get(plural);

//            if (!"compile".equalsIgnoreCase(dependency.getScope())) continue;
                String classifier = dependency.getClassifier();
                if (classifier == null) classifier = "";
                else classifier = "-" + classifier;
                @NonNull final String name = dependency.getGroupId().replace(".", "/") + "/"
                        + dependency.getArtifactId() + "/" + dependency.getVersion() + "/"
                        + dependency.getArtifactId() + "-" + dependency.getVersion() + classifier
                        + "." + dependency.getType();
                @NonNull final File file = new File(settings.getLocalRepository(), name);
                @NonNull final String filename = file.getAbsolutePath();
                files.add(filename);
            }
        return jsonNode(files);
    }

    @NonNull
    @SneakyThrows
    public String yaml(MavenProject mavenProject) {
        @NonNull final Map<String, Object> result = new LinkedHashMap<>();
        @NonNull final String type = mavenProject.getPackaging();
        @NonNull final String plural = plural(type);

        @NonNull final Map<String, Object> pluralMap = new LinkedHashMap<>();
        pluralMap.put(plural, component(mavenProject));

        if ("ArchApi".equals(type)) {
            result.put("archapi", "1.0.0");
            result.put("components", pluralMap);
            JsonNode root = MapperUtil.json().readTree(
                    MapperUtil.json().writeValueAsString(result)
            );
            JsonNode dependencies = getDependencyComponents(mavenProject.getDependencyArtifacts());
            JsonNode node = JsonMerge.merge(root, dependencies);
            return MapperUtil.yaml().writeValueAsString(node);
        }

        result.put("components", pluralMap);
        return MapperUtil.yaml().writeValueAsString(result);
    }

    @NonNull
    @SneakyThrows
    private JsonNode map(@NonNull final String file) {
        @NonNull final ObjectMapper objectMapper = objectMapper(file);
        return objectMapper.readTree(new File(file));
    }

    private ObjectMapper objectMapper(@NonNull final String file) {
        return MapperUtil.yaml();
    }

    @NonNull
    @SneakyThrows
    public List<JsonNode> all(List<String> files) {
        @NonNull final List<JsonNode> result = new ArrayList<>();
        for (final String file : files) {
            if (file == null || file.isEmpty()) continue;
            result.add(map(file));
        }
        return result;
    }

    @NonNull
    public JsonNode jsonNode(List<String> files) {
        @NonNull final List<JsonNode> jsonNodes = all(files);
        @NonNull JsonNode mergedNodes = jsonNodes.get(0);
        for (int i = 1; i < jsonNodes.size(); i++) {
            mergedNodes = JsonMerge.merge(mergedNodes, jsonNodes.get(i));
        }
        return mergedNodes;
    }

}
