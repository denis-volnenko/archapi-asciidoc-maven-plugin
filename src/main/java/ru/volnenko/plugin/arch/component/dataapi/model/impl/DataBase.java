package ru.volnenko.plugin.arch.component.dataapi.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.component.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.component.archapi.model.archapi.impl.ServerReference;
import ru.volnenko.plugin.arch.model.impl.AbstractBasicEntity;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DataBase extends AbstractBasicEntity implements IDataBase {

    @JsonProperty("server")
    private ServerReference serverReference;

}
