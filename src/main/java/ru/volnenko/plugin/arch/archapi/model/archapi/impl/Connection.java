package ru.volnenko.plugin.arch.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Connection extends AbstractModel {

    private String type = "";

    private String name = "";

    private String description = "";

    private Integer port;

}
