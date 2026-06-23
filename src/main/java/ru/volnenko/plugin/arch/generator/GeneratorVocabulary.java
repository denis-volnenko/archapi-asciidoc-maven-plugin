package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Root;
import ru.volnenko.plugin.arch.model.impl.Vocabulary;
import ru.volnenko.plugin.arch.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GeneratorVocabulary extends AbstractGenerator {

    @NonNull
    public static GeneratorVocabulary create() {
        return new GeneratorVocabulary();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("== Термины и определения").append("\n").append("\n");

        stringBuilder.append("[cols=\"0,30,70\"]").append("\n");
        stringBuilder.append("!===").append("\n").append("\n");
        stringBuilder.append("|№ ").append("|Название ").append("|Описание ").append("\n").append("\n");

        if (root().getComponents() != null && root().getComponents().getVocabularies() != null) {
            int index = 1;
            @NonNull final List<Vocabulary> list = new ArrayList<>(root().getComponents().getVocabularies().values());
            Collections.sort(list);
            for (final Vocabulary vocabulary : list) {
                if (vocabulary == null) continue;
                stringBuilder.append("|").append(StringUtil.format(index)).append(". ").append("\n");
                stringBuilder.append("|").append(vocabulary.getName()).append(" ").append("\n");
                stringBuilder.append("|").append(vocabulary.getDescription()).append(" ").append("\n");
                stringBuilder.append("\n");
                index++;
            }
        }

        stringBuilder.append("!===").append("\n").append("\n");
        return stringBuilder.toString();
    }

    @NonNull
    @Override
    public GeneratorVocabulary root(@NonNull final Root root) {
        super.root(root);
        return this;
    }

    @NonNull
    @Override
    public GeneratorVocabulary enabled(boolean enabled) {
        super.enabled(enabled);
        return this;
    }

    @NonNull
    @Override
    public GeneratorVocabulary filename(@NonNull String filename) {
        super.filename(filename);
        return this;
    }

}
