package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
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

        for (final User user : root().users()) {
            renderUser(stringBuilder, user);
        }

        for (@NonNull final Service item : root().services()) {
            renderComponent("Container", stringBuilder, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.System item: root().systems()) {
            renderComponent("System", stringBuilder, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.Database item: root().databases()) {
            renderComponent("ContainerDb", stringBuilder, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.Queue item: root().queues()) {
            renderComponent("Queue", stringBuilder, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.Balancer item: root().balancers()) {
            renderComponent("Container", stringBuilder, item);
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
        String scope = root().scope(mavenProjectDto);
        if (scope == null) scope = "compile";
        String componentName = component;
        if ("provided".equals(scope)) componentName += "_Ex";
        stringBuilder.append(renderComponent(componentName, url, name, "", "", ""));
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
    }

}
