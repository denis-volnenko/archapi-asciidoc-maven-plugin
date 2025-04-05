package ru.volnenko.plugin.archapi.model;

import ru.volnenko.plugin.archapi.model.impl.Server;
import ru.volnenko.plugin.archapi.model.impl.Service;

import java.util.Map;

public interface IComponents {

    Map<String, Server> getServers();

    void setServers(Map<String, Server> servers);

    Map<String, Service> getServices();

    void setServices(Map<String, Service> services);

}
