package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Components {

    private Map<String, Connection> connections;

    private Map<String, Environment> environments;

    private Map<String, Balancer> balancers;

    private Map<String, Database> databases;

    private Map<String, Service> services;

    private Map<String, System> systems;

    private Map<String, Vocabulary> vocabularies;

}
