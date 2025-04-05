package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IComponentsBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;

@NoArgsConstructor
public final class RootBuilder extends AbstractBuilder implements IRootBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder = new ComponentsBuilder();

    @NonNull
    @Override
    public IComponentsBuilder componentsBuilder() {
        return componentsBuilder;
    }

    @NonNull
    public static IRootBuilder create() {
        return new RootBuilder();
    }

}
