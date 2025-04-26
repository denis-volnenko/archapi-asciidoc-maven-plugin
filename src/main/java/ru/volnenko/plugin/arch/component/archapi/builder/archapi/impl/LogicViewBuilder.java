package ru.volnenko.plugin.arch.component.archapi.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.IRootBuilder;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.ILogicViewBuilder;

public final class LogicViewBuilder extends AbstractBuilder implements ILogicViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public LogicViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

}
