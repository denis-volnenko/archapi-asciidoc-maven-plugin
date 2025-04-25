package ru.volnenko.plugin.archapi.basic.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.builder.archapi.IServerBuilder;
import ru.volnenko.plugin.archapi.basic.builder.archapi.IComponentsBuilder;

public final class ServiceBuilder extends AbstractBuilder implements IServerBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder;

    public ServiceBuilder(@NonNull IComponentsBuilder componentsBuilder) {
        this.componentsBuilder = componentsBuilder;
    }
}
