package ru.volnenko.plugin.archapi.basic.model.dataapi;

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
