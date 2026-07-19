package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.apache.maven.model.Exclusion;
import ru.volnenko.plugin.arch.model.IArtifactId;
import ru.volnenko.plugin.arch.model.IGroupId;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenExclusionDto implements IGroupId, IArtifactId {

    private String groupId = "";

    private String artifactId = "";

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

    public MavenExclusionDto(@NonNull final Exclusion exclusion) {
        groupId = exclusion.getGroupId();
        artifactId = exclusion.getArtifactId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MavenExclusionDto that = (MavenExclusionDto) o;
        return Objects.equals(groupId, that.groupId) && Objects.equals(artifactId, that.artifactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, artifactId);
    }

}
