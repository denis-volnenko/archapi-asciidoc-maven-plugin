package ru.volnenko.plugin.archapi.basic.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.builder.archapi.IRootBuilder;
import ru.volnenko.plugin.archapi.basic.builder.archapi.ILogicViewBuilder;

public final class LogicViewBuilder extends AbstractBuilder implements ILogicViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public LogicViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

}
