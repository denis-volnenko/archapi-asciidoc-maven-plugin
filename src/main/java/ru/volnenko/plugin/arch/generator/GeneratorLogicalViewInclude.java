package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public final class GeneratorLogicalViewInclude extends AbstractGenerator {

    @NonNull
    public static GeneratorLogicalViewInclude create() {
        return new GeneratorLogicalViewInclude();
    }

    @NonNull
    @Override
    public String generate() {
        return "";
    }

}
