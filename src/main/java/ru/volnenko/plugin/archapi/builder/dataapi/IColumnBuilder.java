package ru.volnenko.plugin.archapi.builder.dataapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.dataapi.IColumn;

public interface IColumnBuilder {

    @NonNull
    IColumnBuilder column(@NonNull IColumn column);

    @NonNull
    IDataApiBuilder dataApi();

}
