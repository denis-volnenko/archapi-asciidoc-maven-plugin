package ru.volnenko.plugin.arch.api.archapi.generator;

import lombok.NonNull;

public interface ILogicViewBasicGenerator {

    @NonNull
    ILogicViewDiagramGenerator logicViewDiagram();

}
