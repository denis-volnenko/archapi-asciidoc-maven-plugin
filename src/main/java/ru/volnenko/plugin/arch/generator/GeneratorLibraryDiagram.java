package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public class GeneratorLibraryDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorLibraryDiagram create() {
        return new GeneratorLibraryDiagram();
    }

    @NonNull
    @Override
    public String generate() {
        return "";
    }

}
