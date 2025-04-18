package ru.volnenko.plugin.archapi.builder.dataapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.dataapi.IColumnBuilder;
import ru.volnenko.plugin.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.archapi.model.dataapi.IColumn;
import ru.volnenko.plugin.archapi.model.dataapi.impl.Column;

public final class ColumnBuilder implements IColumnBuilder {

    @NonNull
    private final IDataApiBuilder dataApiBuilder;

    @NonNull
    private IColumn column = new Column();

    @NonNull
    @Override
    public IColumnBuilder column(@NonNull final IColumn column) {
        this.column = column;
        return this;
    }

    @NonNull
    public IColumn toColumn() {
        return column;
    }

    @NonNull
    @Override
    public IDataApiBuilder dataApi() {
        return dataApiBuilder;
    }

    public ColumnBuilder(@NonNull final IDataApiBuilder dataApiBuilder) {
        this.dataApiBuilder = dataApiBuilder;
    }

}
