package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public class GeneratorContextViewDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorContextViewDiagram create() {
        return new GeneratorContextViewDiagram();
    }

    @NonNull
    @Override
    public String generate() {
        return "";
    }

}
