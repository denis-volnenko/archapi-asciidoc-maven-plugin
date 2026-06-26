package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.apache.maven.model.Dependency;
import ru.volnenko.plugin.arch.model.ICoordinate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenDependencyDto implements ICoordinate {

    private String groupId = "";

    private String artifactId = "";

    private String version = "";

    private String type = "";

    private String scope = "";

    private List<MavenExclusionDto> exclusions = new ArrayList<>();

    @NonNull
    public ICoordinate coordinate() {
        return this;
    }

    @NonNull
    public List<MavenExclusionDto> exclusions() {
        if (exclusions == null) exclusions = new ArrayList<>();
        return exclusions;
    }

    @NonNull
    public String scope() {
        if (scope == null) return "";
        return scope;
    }

    @NonNull
    public String type() {
        if (type == null) return "";
        return type;
    }

    @NonNull
    public String version() {
        if (version == null) return "";
        return version;
    }

    @NonNull
    public String groupId() {
        if (groupId == null) return "";
        return groupId;
    }

    @NonNull
    public String artifactId() {
        if (artifactId == null) return "";
        return artifactId;
    }

    public MavenDependencyDto(final Dependency dependency) {
        groupId = dependency.getGroupId();
        artifactId = dependency.getArtifactId();
        version = dependency.getVersion();
        type = dependency.getType();
        scope = dependency.getScope();
    }

}
