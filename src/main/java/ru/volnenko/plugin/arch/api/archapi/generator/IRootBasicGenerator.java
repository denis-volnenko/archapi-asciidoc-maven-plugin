package ru.volnenko.plugin.arch.api.archapi.generator;

import lombok.NonNull;

public interface IRootBasicGenerator extends IGenerator {

    @NonNull
    IContextViewBasicGenerator contextView();

    @NonNull
    ILogicViewBasicGenerator logicView();

    @NonNull
    IPhysicViewBasicGenerator physicView();

}
