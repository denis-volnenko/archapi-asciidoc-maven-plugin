package ru.volnenko.plugin.archapi.model.dataapi;

public interface ITable {

    String id();

    String name();

    String description();

    ITable id(String id);

    ITable name(String name);

    ITable description(String description);

}
