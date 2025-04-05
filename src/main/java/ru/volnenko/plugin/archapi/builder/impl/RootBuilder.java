package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IComponentsBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;
import ru.volnenko.plugin.archapi.model.IRoot;
import ru.volnenko.plugin.archapi.model.impl.Root;

@NoArgsConstructor
public final class RootBuilder extends AbstractBuilder implements IRootBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder = new ComponentsBuilder();

    @NonNull
    private Root root = new Root();

    @NonNull
    @Override
    public IRootBuilder title(@NonNull final String title) {
        return this;
    }

    @NonNull
    @Override
    public IRootBuilder description(@NonNull final String description) {
        return this;
    }

    @NonNull
    @Override
    public IComponentsBuilder componentsBuilder() {
        return componentsBuilder;
    }

    @NonNull
    public static IRootBuilder create() {
        return new RootBuilder();
    }

    @NonNull
    @Override
    public IRootBuilder toRoot() {
        return this;
    }

    @NonNull
    @Override
    public IRoot root() {
        return root;
    }

}
