package ru.volnenko.plugin.arch.component.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class EnvironmentReference extends AbstractModel {

    @JsonProperty("$ref")
    private String reference;

}
