package ru.volnenko.plugin.archapi.basic.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.generator.IContextViewDiagramGenerator;
import ru.volnenko.plugin.archapi.basic.generator.IContextViewDocumentGenerator;
import ru.volnenko.plugin.archapi.basic.generator.IContextViewBasicGenerator;

public final class ContextViewBasicGenerator implements IContextViewBasicGenerator {

    @NonNull
    private IContextViewDiagramGenerator contextViewDiagramGenerator;

    @NonNull
    private IContextViewDocumentGenerator contextViewDocumentGenerator;

    @NonNull
    @Override
    public IContextViewDiagramGenerator diagram() {
        return contextViewDiagramGenerator;
    }

    @NonNull
    @Override
    public IContextViewDocumentGenerator document() {
        return contextViewDocumentGenerator;
    }

}
