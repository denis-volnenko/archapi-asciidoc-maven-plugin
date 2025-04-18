package ru.volnenko.plugin.archapi.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.archapi.IComponentsBuilder;
import ru.volnenko.plugin.archapi.builder.archapi.IServerBuilder;

public final class ServiceBuilder extends AbstractBuilder implements IServerBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder;

    public ServiceBuilder(@NonNull IComponentsBuilder componentsBuilder) {
        this.componentsBuilder = componentsBuilder;
    }
}
