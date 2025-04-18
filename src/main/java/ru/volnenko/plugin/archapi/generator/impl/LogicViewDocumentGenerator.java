package ru.volnenko.plugin.archapi.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.generator.ILogicViewDocumentGenerator;
import ru.volnenko.plugin.archapi.model.archapi.impl.LogicView;
import ru.volnenko.plugin.archapi.model.archapi.Root;

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
