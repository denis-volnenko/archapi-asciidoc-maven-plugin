package ru.volnenko.plugin.arch.basic.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.builder.archapi.IContextViewBuilder;
import ru.volnenko.plugin.arch.basic.builder.archapi.IRootBuilder;

public final class ContextViewBuilder extends AbstractBuilder implements IContextViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public ContextViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

}
