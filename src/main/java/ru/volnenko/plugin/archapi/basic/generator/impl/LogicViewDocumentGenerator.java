package ru.volnenko.plugin.archapi.basic.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.generator.ILogicViewDocumentGenerator;
import ru.volnenko.plugin.archapi.basic.model.archapi.Root;
import ru.volnenko.plugin.archapi.basic.model.archapi.impl.LogicView;

public final class LogicViewDocumentGenerator extends AbstractDocumentGenerator implements ILogicViewDocumentGenerator {

    public LogicViewDocumentGenerator(@NonNull final Root root) {
        super(root);
    }

    @NonNull
    public LogicView logicView() {
        return root().getLogicView();
    }

    @Override
    public LogicViewDocumentGenerator append(@NonNull final StringBuilder stringBuilder) {
        stringBuilder.append("== ").append(logicView().getTitle()).append("\n");
        stringBuilder.append(logicView().getDescription()).append("\n");
        return this;
    }

}
