package ru.volnenko.plugin.arch.component.archapi.generator;

import lombok.NonNull;

public interface ILogicViewBasicGenerator {

    @NonNull
    ILogicViewDiagramGenerator logicViewDiagram();

}
