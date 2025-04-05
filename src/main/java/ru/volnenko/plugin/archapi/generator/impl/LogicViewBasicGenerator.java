package ru.volnenko.plugin.archapi.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.generator.ILogicViewBasicGenerator;
import ru.volnenko.plugin.archapi.generator.ILogicViewDiagramGenerator;

public final class LogicViewBasicGenerator implements ILogicViewBasicGenerator {

    @NonNull
    @Override
    public ILogicViewDiagramGenerator logicViewDiagram() {
        return null;
    }

}
