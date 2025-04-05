package ru.volnenko.plugin.archapi.generator;

import lombok.NonNull;

public interface IRootGenerator {

    @NonNull
    IContextViewBasicGenerator contextView();

    @NonNull
    ILogicViewBasicGenerator logicView();

    @NonNull
    IPhysicViewBasicGenerator physicView();

}
