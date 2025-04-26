package ru.volnenko.plugin.arch.basic.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.generator.IRootBasicGenerator;
import ru.volnenko.plugin.arch.basic.generator.IContextViewBasicGenerator;
import ru.volnenko.plugin.arch.basic.generator.ILogicViewBasicGenerator;
import ru.volnenko.plugin.arch.basic.generator.IPhysicViewBasicGenerator;

public final class RootBasicGenerator implements IRootBasicGenerator {

    @NonNull
    private ContextViewBasicGenerator contextViewBasicGenerator;

    @NonNull
    private ILogicViewBasicGenerator logicViewBasicGenerator = new LogicViewBasicGenerator();

    @NonNull
    private PhysicViewBasicGenerator physicViewBasicGenerator;

    @Override
    public @NonNull String generate() {
        return null;
    }

    @NonNull
    @Override
    public IContextViewBasicGenerator contextView() {
        return contextViewBasicGenerator;
    }

    @NonNull
    @Override
    public ILogicViewBasicGenerator logicView() {
        return logicViewBasicGenerator;
    }

    @NonNull
    @Override
    public IPhysicViewBasicGenerator physicView() {
        return physicViewBasicGenerator;
    }

}
