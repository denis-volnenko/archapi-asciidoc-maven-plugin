package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

public final class GeneratorLogicalViewInclude extends AbstractGenerator {

    public GeneratorLogicalViewInclude() {
    }

    @NonNull
    public static GeneratorLogicalViewInclude create() {
        return new GeneratorLogicalViewInclude();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();

        @NonNull final Map<String, Object> rootMap = new LinkedHashMap<>();
        return stringBuilder.toString();
    }

}
