package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.IRoot;

import java.nio.file.Path;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Root implements IRoot {

    private String archapi = "1.0.0";

    private String name = "";

    private String description = "";

    private String url = "";

    private Components components = new Components();

    @NonNull
    public String name() {
        if (name == null) return "";
        return name;
    }

    @NonNull
    public Components components() {
        if (components == null) components = new Components();
        return components;
    }

    public String scope(final MavenProjectDto mavenProjectDto) {
        if (mavenProjectDto == null) return null;
        return scope(mavenProjectDto.groupId(), mavenProjectDto.artifactId(), mavenProjectDto.version(), mavenProjectDto.packaging());
    }

    public String scope(
        final String groupId,
        final String artifactId,
        final String version,
        final String type
    ) {
        if (groupId == null || groupId.isEmpty()) return null;
        if (artifactId == null || artifactId.isEmpty()) return null;
        if (version == null || version.isEmpty()) return null;
        if (type == null || type.isEmpty()) return null;
        final String key = components().archapi().keySet().stream().findFirst().orElse(null);
        if (key == null) return null;
        final ArchApi archApi = components().archapi().get(key);
        if (archApi == null) return null;
        MavenDependencyDto result = null;
        for (@NonNull final MavenDependencyDto mavenDependencyDto: archApi.dependencies()) {
            if (!groupId.equals(mavenDependencyDto.groupId())) continue;
            if (!artifactId.equals(mavenDependencyDto.artifactId())) continue;
            if (!version.equals(mavenDependencyDto.version())) continue;
            if (!type.equals(mavenDependencyDto.type())) continue;
            result = mavenDependencyDto;
            break;
        }
        if (result == null) return null;
        final String scope = result.scope();
        if (scope.isEmpty()) return "compile";
        return scope;
    }

    @NonNull
    public Collection<Environment> environments() {
        return getComponents().environments().values();
    }

    @NonNull
    public Collection<Balancer> balancers() {
        return getComponents().balancers().values();
    }

    @NonNull
    public Collection<Database> databases() {
        return getComponents().databases().values();
    }

    @NonNull
    public Collection<Service> services() {
        return getComponents().services().values();
    }

    @NonNull
    public Collection<System> systems() {
        return getComponents().systems().values();
    }

    @NonNull
    public Collection<Queue> queues() {
        return getComponents().queues().values();
    }

    @NonNull
    public Collection<User> users() {
        return getComponents().users().values();
    }

    @NonNull
    public Collection<Vocabulary> vocabularies() {
        return getComponents().vocabularies().values();
    }

}
