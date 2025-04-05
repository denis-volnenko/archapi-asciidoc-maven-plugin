package ru.volnenko.plugin.archapi.model;

import ru.volnenko.plugin.archapi.model.impl.*;

import java.util.Map;

public interface IComponents {

    Map<String, Network> getNetworks();

    void setNetworks(Map<String, Network> networks);

    Map<String, Server> getServers();

    void setServers(Map<String, Server> servers);

    Map<String, Service> getServices();

    void setServices(Map<String, Service> services);

    Map<String, DataBase> getDatabases();

    void setDatabases(Map<String, DataBase> databases);

    Map<String, Bucket> getBuckets();

    void setBuckets(Map<String, Bucket> buckets);

}
