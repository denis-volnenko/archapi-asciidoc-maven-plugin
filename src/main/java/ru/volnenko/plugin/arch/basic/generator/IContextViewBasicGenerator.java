package ru.volnenko.plugin.arch.basic.generator;

import lombok.NonNull;

public interface IContextViewBasicGenerator {

    @NonNull
    IContextViewDiagramGenerator diagram();

    @NonNull
    IContextViewDocumentGenerator document();

}
