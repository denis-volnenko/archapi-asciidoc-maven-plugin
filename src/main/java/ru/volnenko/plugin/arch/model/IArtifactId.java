package ru.volnenko.plugin.arch.model;

import lombok.NonNull;

public interface IArtifactId {

    String getArtifactId();

    void setArtifactId(String artifact);

    @NonNull
    String artifactId();

}
