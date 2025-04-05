package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.ILogicViewBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;

public final class LogicViewBuilder extends AbstractBuilder implements ILogicViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public LogicViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

}
