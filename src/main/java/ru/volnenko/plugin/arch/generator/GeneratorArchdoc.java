package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Root;

public final class GeneratorArchdoc extends AbstractGenerator {

    private boolean vocabularyEnabled = false;

    private boolean componentsEnabled = false;

    private boolean logicalViewEnabled = false;

    @NonNull
    public GeneratorArchdoc logicalViewEnabled(boolean logicalViewEnabled) {
        this.logicalViewEnabled = logicalViewEnabled;
        return this;
    }

    @NonNull
    public GeneratorArchdoc componentsEnabled(boolean componentsEnabled) {
        this.componentsEnabled = componentsEnabled;
        return this;
    }

    @NonNull
    public GeneratorArchdoc vocabularyEnabled(boolean vocabularyEnabled) {
        this.vocabularyEnabled = vocabularyEnabled;
        return this;
    }

    @NonNull
    public static GeneratorArchdoc create() {
        return new GeneratorArchdoc();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("= [Архитектурный документ]").append("\n").append("\n");

        if (vocabularyEnabled) {
            stringBuilder.append("include::include/vocabulary.adoc[]").append("\n").append("\n");
        }

        if (logicalViewEnabled) {
            stringBuilder.append("== Логическое представление").append("\n").append("\n");
            if (componentsEnabled) {
                stringBuilder.append("include::include/components.adoc[]").append("\n").append("\n");
            }
        }

        return stringBuilder.toString();
    }

    @NonNull
    @Override
    public GeneratorArchdoc root(@NonNull final Root root) {
        super.root(root);
        return this;
    }

    @NonNull
    @Override
    public GeneratorArchdoc enabled(final boolean enabled) {
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
