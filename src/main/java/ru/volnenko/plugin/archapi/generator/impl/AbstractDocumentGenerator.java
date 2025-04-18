package ru.volnenko.plugin.archapi.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.archapi.Root;

public abstract class AbstractDocumentGenerator extends AbstractGenerator {

    @NonNull
    private final Root root;

    @NonNull
    public Root root() {
        return root;
    }

    public AbstractDocumentGenerator(@NonNull final Root root) {
        this.root = root;
    }

}
