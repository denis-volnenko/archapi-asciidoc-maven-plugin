package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.ICoordinate;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenCoordinateDto implements ICoordinate {

    private String groupId = "";

    private String artifactId = "";

    private String version = "";

    private String type = "";

    public MavenCoordinateDto(@NonNull final ICoordinate coordinate) {
        groupId = coordinate.groupId();
        artifactId = coordinate.artifactId();
        version = coordinate.version();
        type = coordinate.type();
    }

    @NonNull
    @Override
    public String artifactId() {
        if (artifactId == null) return "";
        return artifactId;
    }

    @NonNull
    @Override
    public String groupId() {
        if (groupId == null) return "";
        return groupId;
    }

    @NonNull
    @Override
    public String type() {
        if (type == null) return "";
        return type;
    }

    @NonNull
    @Override
    public String version() {
        if (version == null) return "";
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MavenCoordinateDto that = (MavenCoordinateDto) o;
        return groupId.equals(that.groupId) && artifactId.equals(that.artifactId) && version.equals(that.version) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, artifactId, version, type);
    }

    @Override
    public String toString() {
        return groupId + ":" + artifactId + ":" + version + ":" + type;
    }
}
