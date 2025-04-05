package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IComponentsBuilder;
import ru.volnenko.plugin.archapi.builder.IServerBuilder;

public final class ServiceBuilder extends AbstractBuilder implements IServerBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder;

    public ServiceBuilder(@NonNull IComponentsBuilder componentsBuilder) {
        this.componentsBuilder = componentsBuilder;
    }
}
