package ru.volnenko.plugin.arch.archapi.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.archapi.builder.archapi.IComponentsBuilder;
import ru.volnenko.plugin.arch.archapi.builder.archapi.IRootBuilder;
import ru.volnenko.plugin.arch.archapi.model.IRoot;

public final class ComponentsBuilder extends AbstractBuilder implements IComponentsBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public ComponentsBuilder(@NonNull final IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

    @NonNull
    @Override
    public IRootBuilder root() {
        return rootBuilder;
    }

    @NonNull
    @Override
    public IRoot toRoot() {
        return rootBuilder.toRoot();
    }

}
