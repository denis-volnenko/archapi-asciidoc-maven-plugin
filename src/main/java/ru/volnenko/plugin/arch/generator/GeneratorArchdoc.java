package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Root;

public final class GeneratorArchdoc extends AbstractGenerator {

    @NonNull
    public static GeneratorArchdoc create() {
        return new GeneratorArchdoc();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("= [Архитектурный документ]").append("\n").append("\n");


        return stringBuilder.toString();
    }

    @NonNull
    @Override
    public GeneratorArchdoc root(@NonNull Root root) {
        super.root(root);
        return this;
    }

    @NonNull
    @Override
    public GeneratorArchdoc enabled(boolean enabled) {
        super.enabled(enabled);
        return this;
    }

    @NonNull
    @Override
    public GeneratorArchdoc filename(@NonNull final String filename) {
        super.filename(filename);
        return this;
    }

}
