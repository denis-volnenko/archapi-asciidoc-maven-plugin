package ru.volnenko.plugin.arch.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.archapi.model.IServer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Service extends AbstractModel implements IServer {

    private String name;

    private String host;

    private String description;

    private List<Integer> ports;

}
