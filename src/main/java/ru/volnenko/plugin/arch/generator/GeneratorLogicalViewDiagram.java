package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public class GeneratorLogicalViewDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorLogicalViewDiagram create() {
        return new GeneratorLogicalViewDiagram();
    }

    @NonNull
    @Override
    public  String generate() {
        return "";
    }

}
