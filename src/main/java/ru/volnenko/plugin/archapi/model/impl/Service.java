package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IServer;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class Service extends AbstractModel implements IServer {

    private String name;

    private String host;

    private String description;

    private List<Integer> ports;

}
