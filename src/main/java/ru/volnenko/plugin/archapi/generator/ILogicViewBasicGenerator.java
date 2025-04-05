package ru.volnenko.plugin.archapi.generator;

import lombok.NonNull;

public interface ILogicViewBasicGenerator {

    @NonNull
    ILogicViewDiagramGenerator logicViewDiagram();

}
