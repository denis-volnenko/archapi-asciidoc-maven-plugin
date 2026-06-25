package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Components;
import ru.volnenko.plugin.arch.model.impl.Environment;
import ru.volnenko.plugin.arch.model.impl.Service;
import ru.volnenko.plugin.arch.model.impl.User;
import ru.volnenko.plugin.arch.model.maven.MavenProjectDto;

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

        final Components components = root().getComponents();
        if (components == null) return "";

        if (components.getUsers() != null) {
            for (final User user : components.getUsers().values()) {
               renderUser(stringBuilder, user);
            }
        }

        if (components.getServices() != null) {
            for (@NonNull final Service item : components.getServices().values()) {
                renderComponent("Container", stringBuilder, item);
            }
        }

        if (components.getSystems() != null) {
            for (final ru.volnenko.plugin.arch.model.impl.System item: components.getSystems().values()) {
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
        stringBuilder.append(renderComponent(component, mavenProjectDto.getUrl(), mavenProjectDto.getDescription(), "", mavenProjectDto.getName(), ""));
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
    }

}
