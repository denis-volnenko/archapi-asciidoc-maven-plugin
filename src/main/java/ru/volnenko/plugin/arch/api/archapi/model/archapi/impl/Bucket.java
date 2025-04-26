package ru.volnenko.plugin.arch.api.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.api.archapi.model.IBucket;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Bucket extends AbstractModel implements IBucket {

    private String name = "";

    private String description = "";

    @JsonProperty("server")
    private ServerReference serverReference;

}
