package ru.volnenko.plugin.archapi.generator;

import lombok.NonNull;

public interface IContextViewBasicGenerator {

    @NonNull
    IContextViewDiagramGenerator diagram();

    @NonNull
    IContextViewDocumentGenerator document();

}
