package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Components;
import ru.volnenko.plugin.arch.model.impl.Environment;
import ru.volnenko.plugin.arch.model.impl.Service;
import ru.volnenko.plugin.arch.model.impl.User;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;

import java.util.List;

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

        if (components.getDatabases() != null) {
            for (final ru.volnenko.plugin.arch.model.impl.Database item: components.getDatabases().values()) {
                renderComponent("ContainerDb", stringBuilder, item);
            }
        }

        if (components.getQueues() != null) {
            for (final ru.volnenko.plugin.arch.model.impl.Queue item: components.getQueues().values()) {
                renderComponent("Queue", stringBuilder, item);
            }
        }

        if (components.getBalancers() != null) {
            for (final ru.volnenko.plugin.arch.model.impl.Balancer item: components.getBalancers().values()) {
                renderComponent("Container", stringBuilder, item);
            }
        }

        return stringBuilder.toString();
    }

    private void renderComponent(
            @NonNull final String component,
            @NonNull final StringBuilder stringBuilder,
            @NonNull final MavenProjectDto mavenProjectDto
    ) {
        @NonNull final List<Environment> environments = boundaries(mavenProjectDto.dependencies());
        startBoundary(stringBuilder, environments);
        for (int i = 0; i < environments.size(); i++) stringBuilder.append("\t");
        @NonNull final String url = mavenProjectDto.url();
        @NonNull final String name = mavenProjectDto.name();
        stringBuilder.append(renderComponent(component, url, name, "", "", ""));
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
    }

}
