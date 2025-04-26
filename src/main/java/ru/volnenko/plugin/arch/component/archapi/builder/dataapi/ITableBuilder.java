package ru.volnenko.plugin.arch.component.archapi.builder.dataapi;

import lombok.NonNull;

public interface ITableBuilder {

    @NonNull
    ITableBuilder id(@NonNull String id);

    @NonNull
    ITableBuilder name(@NonNull String name);

}
