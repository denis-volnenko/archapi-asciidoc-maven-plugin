package ru.volnenko.plugin.archapi.model;

public interface IBasicVersion extends IBasicEntity {

    String getVersion();

    void setVersion(String version);

    String version();

    void version(String version);

}
