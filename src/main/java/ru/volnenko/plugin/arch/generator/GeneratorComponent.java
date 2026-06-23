package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Root;

public final class GeneratorComponent extends AbstractGenerator {

    @NonNull
    public static GeneratorComponent create() {
        return new GeneratorComponent();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("== Архитектурно значимые компоненты").append("\n").append("\n");

        stringBuilder.append("[cols=\"0,30,70\"]").append("\n");
        stringBuilder.append("!===").append("\n").append("\n");
        stringBuilder.append("|№ ").append("|Название ").append("|Описание ").append("\n").append("\n");

        stringBuilder.append("!===").append("\n").append("\n");
        return stringBuilder.toString();
    }

    @NonNull
    @Override
    public GeneratorComponent root(@NonNull Root root) {
        super.root(root);
        return this;
    }

    @NonNull
    @Override
    public GeneratorComponent enabled(boolean enabled) {
        super.enabled(enabled);
        return this;
    }

    @NonNull
    @Override
    public GeneratorComponent filename(@NonNull String filename) {
        super.filename(filename);
        return this;
    }

}
