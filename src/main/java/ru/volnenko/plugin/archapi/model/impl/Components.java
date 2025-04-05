package ru.volnenko.plugin.archapi.model.impl;

import ru.volnenko.plugin.archapi.model.IComponent;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Components implements IComponent {

    private Map<String, Server> servers = new LinkedHashMap<>();

    private Map<String, Service> services = new LinkedHashMap<>();

}
