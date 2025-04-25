package ru.volnenko.plugin.archapi.basic.model.dataapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.basic.model.archapi.impl.AbstractModel;
import ru.volnenko.plugin.archapi.basic.model.archapi.impl.ServerReference;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Topic extends AbstractModel {

    @JsonProperty("server")
    private ServerReference serverReference;

}
