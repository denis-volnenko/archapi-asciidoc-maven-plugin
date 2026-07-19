package ru.volnenko.plugin.arch.model.impl;

import lombok.NonNull;

import java.util.Objects;


public final class MavenExclusion {

    @NonNull
    private String groupId = "";

    @NonNull
    private String artifactId = "";

    @NonNull
    private String version = "";

    @NonNull
    private String type = "";

    @NonNull
    private String dependencyGroupId = "";

    @NonNull
    private String dependencyArtifactId = "";

    public MavenExclusion(
            @NonNull final MavenProjectDto mavenProjectDto,
            @NonNull final MavenProjectDto mavenDependencyDto
    ) {
        groupId = mavenProjectDto.groupId();
        artifactId = mavenProjectDto.artifactId();
        version = mavenProjectDto.version();
        type = mavenProjectDto.type();

        dependencyGroupId = mavenDependencyDto.groupId();
        dependencyArtifactId = mavenDependencyDto.artifactId();
    }

    public MavenExclusion(
            @NonNull final MavenProjectDto mavenProjectDto,
            @NonNull final MavenExclusionDto mavenExclusionDto
    ) {
        groupId = mavenProjectDto.groupId();
        artifactId = mavenProjectDto.artifactId();
        version = mavenProjectDto.version();
        type = mavenProjectDto.type();

        dependencyGroupId = mavenExclusionDto.groupId();
        dependencyArtifactId = mavenExclusionDto.artifactId();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MavenExclusion that = (MavenExclusion) o;
        return groupId.equals(that.groupId) && artifactId.equals(that.artifactId) && version.equals(that.version) && type.equals(that.type) && dependencyGroupId.equals(that.dependencyGroupId) && dependencyArtifactId.equals(that.dependencyArtifactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, artifactId, version, type, dependencyGroupId, dependencyArtifactId);
    }

    @Override
    public String toString() {
        return groupId + ":" + artifactId + " - " + dependencyGroupId + ":" + dependencyArtifactId;
    }
}
