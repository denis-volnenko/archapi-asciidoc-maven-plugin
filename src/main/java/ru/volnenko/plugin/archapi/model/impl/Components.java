package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IComponents;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Components extends AbstractModel implements IComponents {

    private Map<String, Network> networks = new LinkedHashMap<>();

    private Map<String, Server> servers = new LinkedHashMap<>();

    private Map<String, Service> services = new LinkedHashMap<>();

    private Map<String, DataBase> databases = new LinkedHashMap<>();

    private Map<String, Bucket> buckets = new LinkedHashMap<>();

    private Map<String, Topic> topics = new LinkedHashMap<>();

    private Map<String, Queue> queue = new LinkedHashMap<>();

    private Map<String, User> users = new LinkedHashMap<>();

    private Map<String, Connection> connections = new LinkedHashMap<>();

}
