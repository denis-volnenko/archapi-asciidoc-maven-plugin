package ru.volnenko.plugin.arch.archapi.builder.dataapi;

import lombok.NonNull;

public interface IDataApiBuilder {

    @NonNull
    IEntityBuilder entity();

    @NonNull
    IEntityBuilder entity(@NonNull String name);

    @NonNull
    ITableBuilder table();

    @NonNull
    ITableBuilder table(@NonNull String name);

    @NonNull
    IColumnBuilder column();

    @NonNull
    IColumnBuilder column(@NonNull String name);

}
