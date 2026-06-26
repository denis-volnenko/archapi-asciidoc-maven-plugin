package ru.volnenko.plugin.arch.model;

import lombok.NonNull;

public interface IVersion {

    String getVersion();

    void setVersion(String version);

    @NonNull
    String version();

}
