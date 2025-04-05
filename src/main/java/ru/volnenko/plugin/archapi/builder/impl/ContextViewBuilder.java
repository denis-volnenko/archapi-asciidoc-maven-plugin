package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IContextViewBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;

public final class ContextViewBuilder extends AbstractBuilder implements IContextViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public ContextViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

}
