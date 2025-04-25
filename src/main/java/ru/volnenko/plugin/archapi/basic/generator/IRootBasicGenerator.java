package ru.volnenko.plugin.archapi.basic.generator;

import lombok.NonNull;

public interface IRootBasicGenerator extends IGenerator {

    @NonNull
    IContextViewBasicGenerator contextView();

    @NonNull
    ILogicViewBasicGenerator logicView();

    @NonNull
    IPhysicViewBasicGenerator physicView();

}
