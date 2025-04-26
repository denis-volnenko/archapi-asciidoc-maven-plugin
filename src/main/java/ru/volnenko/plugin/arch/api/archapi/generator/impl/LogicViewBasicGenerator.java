package ru.volnenko.plugin.arch.api.archapi.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.archapi.generator.ILogicViewDiagramGenerator;
import ru.volnenko.plugin.arch.api.archapi.generator.ILogicViewBasicGenerator;

public final class LogicViewBasicGenerator implements ILogicViewBasicGenerator {

    @NonNull
    @Override
    public ILogicViewDiagramGenerator logicViewDiagram() {
        return null;
    }

}
