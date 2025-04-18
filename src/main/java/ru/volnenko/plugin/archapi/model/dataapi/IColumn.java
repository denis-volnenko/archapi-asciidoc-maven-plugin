package ru.volnenko.plugin.archapi.model.dataapi;

public interface IColumn {

    String id();

    String name();

    String description();

    IColumn id(String id);

    IColumn name(String name);

    IColumn description(String description);

}
