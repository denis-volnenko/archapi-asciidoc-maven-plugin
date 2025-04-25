package ru.volnenko.plugin.archapi.basic.generator;

import lombok.NonNull;

public interface IContextViewBasicGenerator {

    @NonNull
    IContextViewDiagramGenerator diagram();

    @NonNull
    IContextViewDocumentGenerator document();

}
