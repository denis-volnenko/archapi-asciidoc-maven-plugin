package ru.volnenko.plugin.arch.basic.generator;

import lombok.NonNull;

public interface IRootBasicGenerator extends IGenerator {

    @NonNull
    IContextViewBasicGenerator contextView();

    @NonNull
    ILogicViewBasicGenerator logicView();

    @NonNull
    IPhysicViewBasicGenerator physicView();

}
