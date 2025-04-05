package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.volnenko.plugin.archapi.model.IDataBase;

public final class DataBase extends AbstractModel implements IDataBase {

    @JsonProperty("server")
    private ServerReference serverReference;

}
