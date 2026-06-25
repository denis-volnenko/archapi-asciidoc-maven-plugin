package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Components;
import ru.volnenko.plugin.arch.model.impl.Environment;
import ru.volnenko.plugin.arch.model.impl.Service;
import ru.volnenko.plugin.arch.model.impl.User;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;

import java.util.List;

public final class GeneratorContextViewInclude extends AbstractGenerator {

    @NonNull
    public static GeneratorContextViewInclude create() {
        return new GeneratorContextViewInclude();
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        @NonNull final Components components = root().components();

        if (components.getUsers() != null) {
            for (@NonNull final User user : components.getUsers().values()) {
               renderUser(stringBuilder, user);
            }
        }

        if (components.getServices() != null) {
            for (@NonNull final Service item : components.getServices().values()) {
                renderComponent("Container", stringBuilder, item);
            }
        }

        if (components.getSystems() != null) {
            for (@NonNull final ru.volnenko.plugin.arch.model.impl.System item: components.getSystems().values()) {
                renderComponent("System", stringBuilder, item);
            }
        }

        return stringBuilder.toString();
    }

    private void renderComponent(
            @NonNull final String component,
            @NonNull final StringBuilder stringBuilder,
            @NonNull final MavenProjectDto mavenProjectDto
    ) {
        @NonNull final List<Environment> environments = boundaries(mavenProjectDto.getDependencies());
        startBoundary(stringBuilder, environments);
        for (int i = 0; i < environments.size(); i++) stringBuilder.append("\t");
        @NonNull final String url = mavenProjectDto.url();
        @NonNull final String description = mavenProjectDto.description();
        @NonNull final String name = mavenProjectDto.name();
        stringBuilder.append(renderComponent(component, url, description, "", name, ""));
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
    }

}
