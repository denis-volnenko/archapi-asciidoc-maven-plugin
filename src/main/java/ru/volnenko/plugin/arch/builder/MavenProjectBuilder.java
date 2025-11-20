package ru.volnenko.plugin.arch.builder;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.maven.project.MavenProject;
import ru.volnenko.plugin.arch.model.impl.*;
import ru.volnenko.plugin.arch.model.impl.System;
import ru.volnenko.plugin.arch.util.MapperUtil;

import java.util.LinkedHashMap;
import java.util.Map;

public final class MavenProjectBuilder {

    @NonNull
    private static Map<String, Class> MAP = new LinkedHashMap<>();

    @NonNull
    private static Map<String, String> PLURALS = new LinkedHashMap<>();

    static {
        registry(ArchAPI.class, "archapi");
        registry(Balancer.class, "balancers");
        registry(Database.class, "databases");
        registry(Service.class, "services");
        registry(System.class, "systems");
        registry(Vocabulary.class, "vocabularies");
        registry(User.class, "users");
        registry(Queue.class, "queues");
        registry(Environment.class, "environments");
        registry(Connection.class, "connections");
    }

    private static <T extends AbstractModel> void registry(final Class<T> clazz, final String plural) {
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
    private static Map<String, Object> component(@NonNull MavenProject mavenProject) {
        @NonNull final Map<String, Object> component = new LinkedHashMap<>();
        component.put("name", mavenProject.getName());
        component.put("description", mavenProject.getDescription());

        @NonNull final Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put(mavenProject.getArtifactId(), component);
        return wrapper;
    }

    @NonNull
    @SneakyThrows
    public static String yaml(MavenProject mavenProject) {
        @NonNull final Map<String, Object> result = new LinkedHashMap<>();
        @NonNull final String type = mavenProject.getPackaging();
        @NonNull final String plural = plural(type);

        @NonNull final Map<String, Object> pluralMap = new LinkedHashMap<>();
        pluralMap.put(plural, component(mavenProject));
        result.put("components", pluralMap);

        if ("ArchAPI".equals(type)) {
            result.put("archapi", "1.0.0");
        }

        return MapperUtil.yaml().writeValueAsString(result);
    }

}
