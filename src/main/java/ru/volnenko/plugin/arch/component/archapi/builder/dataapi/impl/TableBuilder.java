package ru.volnenko.plugin.arch.component.archapi.builder.dataapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.arch.component.archapi.builder.dataapi.ITableBuilder;

public final class TableBuilder implements ITableBuilder {

    @NonNull
    private final IDataApiBuilder dataApiBuilder;

    public TableBuilder(@NonNull IDataApiBuilder dataApiBuilder) {
        this.dataApiBuilder = dataApiBuilder;
    }

    @NonNull
    @Override
    public ITableBuilder id(@NonNull final String id) {
        return this;
    }

    @NonNull
    @Override
    public ITableBuilder name(@NonNull final String name) {
        return this;
    }

}
