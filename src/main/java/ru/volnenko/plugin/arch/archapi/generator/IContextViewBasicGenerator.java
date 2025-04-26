package ru.volnenko.plugin.arch.archapi.generator;

import lombok.NonNull;

public interface IContextViewBasicGenerator {

    @NonNull
    IContextViewDiagramGenerator diagram();

    @NonNull
    IContextViewDocumentGenerator document();

}
