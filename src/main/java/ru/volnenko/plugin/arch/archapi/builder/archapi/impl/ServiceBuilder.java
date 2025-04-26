package ru.volnenko.plugin.arch.archapi.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.archapi.builder.archapi.IServerBuilder;
import ru.volnenko.plugin.arch.archapi.builder.archapi.IComponentsBuilder;

public final class ServiceBuilder extends AbstractBuilder implements IServerBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder;

    public ServiceBuilder(@NonNull IComponentsBuilder componentsBuilder) {
        this.componentsBuilder = componentsBuilder;
    }
}
