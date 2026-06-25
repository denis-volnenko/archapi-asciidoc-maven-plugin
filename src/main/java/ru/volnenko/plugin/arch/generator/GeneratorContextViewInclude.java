package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Components;
import ru.volnenko.plugin.arch.model.impl.Service;

public final class GeneratorContextViewInclude extends AbstractGenerator {

    @NonNull
    public static GeneratorContextViewInclude create() {
        return new GeneratorContextViewInclude();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();

        final Components components = root().getComponents();
        if (components == null) return "";

        if (components.getServices() != null) {
            for (final Service service : components.getServices().values()) {
                stringBuilder.append("Container(" + service.getUrl() + ", \"" + service.getDescription() + "\", " + "\"\""+ ", \"" + service.getName() + "\"" + ")");
                stringBuilder.append("\n\n");
            }
        }

        return stringBuilder.toString();
    }

}
