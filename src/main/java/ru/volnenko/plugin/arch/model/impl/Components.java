package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Components {

    private Map<String, Environment> environments = Collections.emptyMap();

    private Map<String, Balancer> balancers = Collections.emptyMap();

    private Map<String, Database> databases = Collections.emptyMap();

    private Map<String, Service> services = Collections.emptyMap();

    private Map<String, System> systems = Collections.emptyMap();

    private Map<String, Queue> queues = Collections.emptyMap();

    private Map<String, Vocabulary> vocabularies = Collections.emptyMap();

    private Map<String, User> users = Collections.emptyMap();

}
