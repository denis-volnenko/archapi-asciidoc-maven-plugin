package ru.volnenko.plugin.archapi.builder.dataapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.dataapi.IColumn;

public interface IColumnBuilder {

    @NonNull
    IDataApiBuilder dataApi();

    @NonNull
    IColumnBuilder column(@NonNull IColumn column);

    @NonNull
    IColumnBuilder name(@NonNull String name);

    @NonNull
    IColumn toColumn();

}
