package ru.volnenko.plugin.archapi.dataapi.model;

import lombok.NonNull;

public interface IColumn {

    String id();

    String name();

    String description();

    @NonNull
    IColumn id(String id);

    @NonNull
    IColumn name(String name);

    @NonNull
    IColumn description(String description);

}
