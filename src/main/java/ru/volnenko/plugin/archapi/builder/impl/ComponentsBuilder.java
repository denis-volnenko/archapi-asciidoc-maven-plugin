package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IComponentsBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;
import ru.volnenko.plugin.archapi.model.IRoot;
import ru.volnenko.plugin.archapi.model.impl.Components;

public final class ComponentsBuilder extends AbstractBuilder implements IComponentsBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public ComponentsBuilder(@NonNull final IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
        init(this.rootBuilder.toRoot());
    }

    private void init(@NonNull IRoot root) {
        if (root.getComponents() != null) return;
        root.setComponents(new Components());
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
