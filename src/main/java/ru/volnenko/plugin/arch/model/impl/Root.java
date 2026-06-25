package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.IRoot;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Root implements IRoot {

    private String archapi = "1.0.0";

    private Components components = new Components();

    @NonNull
    public Components components() {
        if (components == null) components = new Components();
        return components;
    }

    @NonNull
    public Collection<Environment> environments() {
        return getComponents().environments().values();
    }

    @NonNull
    public Collection<Balancer> balancers() {
        return getComponents().balancers().values();
    }

    @NonNull
    public Collection<Database> databases() {
        return getComponents().databases().values();
    }

    @NonNull
    public Collection<Service> services() {
        return getComponents().services().values();
    }

    @NonNull
    public Collection<System> systems() {
        return getComponents().systems().values();
    }

    @NonNull
    public Collection<Queue> queues() {
        return getComponents().queues().values();
    }

    @NonNull
    public Collection<User> users() {
        return getComponents().users().values();
    }

    @NonNull
    public Collection<Vocabulary> vocabularies() {
        return getComponents().vocabularies().values();
    }

}
