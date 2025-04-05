package ru.volnenko.plugin.archapi.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.generator.IContextViewBasicGenerator;
import ru.volnenko.plugin.archapi.generator.IContextViewDiagramGenerator;
import ru.volnenko.plugin.archapi.generator.IContextViewDocumentGenerator;

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
