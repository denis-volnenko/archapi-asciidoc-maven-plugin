package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Components {

    private Map<String, ArchApi> archapi = new LinkedHashMap<>();

    private Map<String, Environment> environments = new LinkedHashMap<>();

    private Map<String, Balancer> balancers = new LinkedHashMap<>();

    private Map<String, Database> databases = new LinkedHashMap<>();

    private Map<String, Service> services = new LinkedHashMap<>();

    private Map<String, System> systems = new LinkedHashMap<>();

    private Map<String, Queue> queues = new LinkedHashMap<>();

    private Map<String, Vocabulary> vocabularies = new LinkedHashMap<>();

    private Map<String, User> users = new LinkedHashMap<>();

    @NonNull
    public Map<String, ArchApi> archapi() {
        if (archapi == null) archapi = new LinkedHashMap<>();
        return archapi;
    }

    @NonNull
    public Map<String, Environment> environments() {
        if (environments == null) environments = new LinkedHashMap<>();
        return environments;
    }

    @NonNull
    public Map<String, Balancer> balancers() {
        if (balancers == null) balancers = new LinkedHashMap<>();
        return balancers;
    }

    @NonNull
    public Map<String, Database> databases() {
        if (databases == null) databases = new LinkedHashMap<>();
        return databases;
    }

    @NonNull
    public Map<String, Service> services() {
        if (services == null) services = new LinkedHashMap<>();
        return services;
    }

    @NonNull
    public Map<String, System> systems() {
        if (systems == null) systems = new LinkedHashMap<>();
        return systems;
    }

    @NonNull
    public Map<String, Queue> queues() {
        if (queues == null) queues = new LinkedHashMap<>();
        return queues;
    }

    @NonNull
    public Map<String, User> users() {
        if (users == null) users = new LinkedHashMap<>();
        return users;
    }

    @NonNull
    public Map<String, Vocabulary> vocabularies() {
        if (vocabularies == null) vocabularies = new LinkedHashMap<>();
        return vocabularies;
    }

}
