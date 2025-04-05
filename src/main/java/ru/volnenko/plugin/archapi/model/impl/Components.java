package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IComponent;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class Components implements IComponent {

    private Map<String, Server> servers = new LinkedHashMap<>();

    private Map<String, Service> services = new LinkedHashMap<>();

}
