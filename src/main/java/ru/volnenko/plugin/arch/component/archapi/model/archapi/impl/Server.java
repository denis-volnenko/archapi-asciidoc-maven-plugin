package ru.volnenko.plugin.arch.component.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Server extends AbstractModel {

    private String name;

    private String host;

    private String description;

    private List<Integer> ports;

}
