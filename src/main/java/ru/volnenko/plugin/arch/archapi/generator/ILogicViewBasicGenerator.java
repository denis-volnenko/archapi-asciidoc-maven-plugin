package ru.volnenko.plugin.arch.archapi.generator;

import lombok.NonNull;

public interface ILogicViewBasicGenerator {

    @NonNull
    ILogicViewDiagramGenerator logicViewDiagram();

}
