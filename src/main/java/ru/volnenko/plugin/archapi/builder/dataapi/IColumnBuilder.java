package ru.volnenko.plugin.archapi.builder.dataapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.dataapi.IColumn;

public interface IColumnBuilder {

    @NonNull
    IDataApiBuilder dataApi();

    @NonNull
    IColumnBuilder id(@NonNull String id);

    @NonNull
    IColumnBuilder name(@NonNull String name);

    @NonNull
    IColumnBuilder column(@NonNull IColumn column);

    @NonNull
    IColumn toColumn();

}
