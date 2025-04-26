package ru.volnenko.plugin.arch.api.archapi.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.archapi.builder.archapi.IContextViewBuilder;
import ru.volnenko.plugin.arch.api.archapi.builder.archapi.IRootBuilder;

public final class ContextViewBuilder extends AbstractBuilder implements IContextViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public ContextViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

}
