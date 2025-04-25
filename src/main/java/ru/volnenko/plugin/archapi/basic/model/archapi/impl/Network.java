package ru.volnenko.plugin.archapi.basic.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Network extends AbstractModel {

    private String name = "";

    private String mask = "";

    private String description = "";

}
