package ru.volnenko.plugin.archapi.basic.builder.dataapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.dataapi.model.IColumn;

public interface IColumnBuilder {

    @NonNull
    IDataApiBuilder dataApi();

    @NonNull
    IColumnBuilder id(@NonNull String id);

    @NonNull
    IColumnBuilder name(@NonNull String name);

    @NonNull
    IColumnBuilder description(@NonNull String description);

    @NonNull
    IColumnBuilder column(@NonNull IColumn column);

    @NonNull
    IColumn toColumn();

}
