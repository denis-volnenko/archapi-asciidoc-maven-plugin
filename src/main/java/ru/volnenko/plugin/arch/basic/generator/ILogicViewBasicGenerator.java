package ru.volnenko.plugin.arch.basic.generator;

import lombok.NonNull;

public interface ILogicViewBasicGenerator {

    @NonNull
    ILogicViewDiagramGenerator logicViewDiagram();

}
