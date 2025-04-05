package ru.volnenko.plugin.archapi.generator;

import lombok.NonNull;

public interface IRootBasicGenerator extends IGenerator {

    @NonNull
    IContextViewBasicGenerator contextView();

    @NonNull
    ILogicViewBasicGenerator logicView();

    @NonNull
    IPhysicViewBasicGenerator physicView();

}
