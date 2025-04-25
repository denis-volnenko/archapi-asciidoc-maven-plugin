package ru.volnenko.plugin.archapi.basic.model.dataapi;

import lombok.NonNull;

public interface ITable {

    String id();

    String name();

    String description();

    @NonNull
    ITable id(@NonNull String id);

    @NonNull
    ITable name(@NonNull String name);

    @NonNull
    ITable description(@NonNull String description);

}
