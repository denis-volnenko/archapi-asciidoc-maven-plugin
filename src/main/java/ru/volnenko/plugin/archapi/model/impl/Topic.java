package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class Topic extends AbstractModel {

    @JsonProperty("server")
    private ServerReference serverReference;

}
