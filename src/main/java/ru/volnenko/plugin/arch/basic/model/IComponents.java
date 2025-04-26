package ru.volnenko.plugin.arch.basic.model;

import ru.volnenko.plugin.arch.basic.model.archapi.impl.Bucket;
import ru.volnenko.plugin.arch.basic.model.archapi.impl.Network;
import ru.volnenko.plugin.arch.basic.model.archapi.impl.Server;
import ru.volnenko.plugin.arch.basic.model.archapi.impl.Service;
import ru.volnenko.plugin.arch.dataapi.model.impl.DataBase;

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
