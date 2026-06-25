package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.*;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;
import ru.volnenko.plugin.arch.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        @NonNull final List<MavenProjectDto> models = new ArrayList<>();
        final Components components = root().getComponents();
        if (components != null) {
            if (components.getServices() != null) models.addAll(components.getServices().values());
            if (components.getDatabases() != null) models.addAll(components.getDatabases().values());
            if (components.getBalancers() != null) models.addAll(components.getBalancers().values());
            if (components.getSystems() != null) models.addAll(components.getSystems().values());
            if (components.getQueues() != null) models.addAll(components.getQueues().values());
        }

        int index = 1;
        Collections.sort(models);
        for (final MavenProjectDto model : models) {
            stringBuilder.append("|").append(StringUtil.format(index)).append(". ").append("\n");
            stringBuilder.append("|").append(model.getName()).append(" ").append("\n");
            stringBuilder.append("|").append(model.getDescription()).append(" ").append("\n");
            stringBuilder.append("\n");
            index++;
        }

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
