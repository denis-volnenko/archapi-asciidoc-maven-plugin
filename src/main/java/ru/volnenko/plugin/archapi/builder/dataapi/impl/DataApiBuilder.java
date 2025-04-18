package ru.volnenko.plugin.archapi.builder.dataapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.dataapi.IColumnBuilder;
import ru.volnenko.plugin.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.archapi.builder.dataapi.IEntityBuilder;
import ru.volnenko.plugin.archapi.builder.dataapi.ITableBuilder;

public final class DataApiBuilder implements IDataApiBuilder {

    @NonNull
    @Override
    public IEntityBuilder entity() {
        return null;
    }

    @NonNull
    @Override
    public IEntityBuilder entity(@NonNull final String name) {
        return null;
    }

    @NonNull
    @Override
    public ITableBuilder table() {
        return null;
    }

    @NonNull
    @Override
    public ITableBuilder table(@NonNull final String name) {
        return null;
    }

    @NonNull
    @Override
    public IColumnBuilder column() {
        return new ColumnBuilder(this);
    }

    @NonNull
    @Override
    public IColumnBuilder column(@NonNull String name) {
        return new ColumnBuilder(this);
    }

}
