package ru.volnenko.plugin.archapi.model.dataapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IDataBase;
import ru.volnenko.plugin.archapi.model.archapi.impl.AbstractModel;
import ru.volnenko.plugin.archapi.model.archapi.impl.ServerReference;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DataBase extends AbstractModel implements IDataBase {

    @JsonProperty("server")
    private ServerReference serverReference;

}
