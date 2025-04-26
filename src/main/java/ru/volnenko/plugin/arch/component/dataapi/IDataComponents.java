package ru.volnenko.plugin.arch.component.dataapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.dataapi.model.IColumn;
import ru.volnenko.plugin.arch.component.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.component.dataapi.model.ITable;
import ru.volnenko.plugin.arch.component.dataapi.model.ITopic;

import java.util.Map;

public interface IDataComponents {

    @NonNull
    Map<String, IColumn> columns();

    @NonNull
    Map<String, IDataBase> databases();

    @NonNull
    Map<String, ITable> tables();

    @NonNull
    Map<String, ITopic> topics();

}
