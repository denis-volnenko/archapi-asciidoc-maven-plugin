package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.ICoordinate;
import ru.volnenko.plugin.arch.model.impl.*;

import java.lang.System;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GeneratorLogicalViewInclude extends AbstractGenerator {

    public GeneratorLogicalViewInclude() {
    }

    @NonNull
    public static GeneratorLogicalViewInclude create() {
        return new GeneratorLogicalViewInclude();
    }

    private void dependencies(
            @NonNull final Map<ICoordinate, ICoordinate> dependencies,
            @NonNull final MavenProjectDto mavenProjectDto
    ) {
        for (@NonNull final MavenDependencyDto mavenDependencyDto: mavenProjectDto.dependencies()) {
            dependencies.put(new MavenCoordinateDto(mavenProjectDto), new MavenCoordinateDto(mavenDependencyDto));
        }
    }

    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        @NonNull final Map<ICoordinate, ICoordinate> dependencies = new LinkedHashMap<>();
        @NonNull final Map<ICoordinate, MavenProjectDto> variables = new LinkedHashMap<>();

        for (final User user : root().users()) {
            renderUser(stringBuilder, user, variables);
            dependencies(dependencies, user);
        }

        for (@NonNull final Service item : root().services()) {
            renderComponent("Container", stringBuilder, item, variables);
            dependencies(dependencies, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.System item: root().systems()) {
            renderComponent("System", stringBuilder, item, variables);
            dependencies(dependencies, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.Database item: root().databases()) {
            renderComponent("ContainerDb", stringBuilder, item, variables);
            dependencies(dependencies, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.Queue item: root().queues()) {
            renderComponent("Queue", stringBuilder, item, variables);
            dependencies(dependencies, item);
        }

        for (final ru.volnenko.plugin.arch.model.impl.Balancer item: root().balancers()) {
            renderComponent("Container", stringBuilder, item, variables);
            dependencies(dependencies, item);
        }

        renderDependencies(stringBuilder, dependencies, variables);

        return stringBuilder.toString();
    }

    private void renderDependencies(
            @NonNull final StringBuilder stringBuilder,
            @NonNull final Map<ICoordinate, ICoordinate> dependencies,
            @NonNull final Map<ICoordinate, MavenProjectDto> variables
    ) {
        @NonNull final Set<Map.Entry<ICoordinate, ICoordinate>> set = dependencies.entrySet();
        for (@NonNull final Map.Entry<ICoordinate, ICoordinate> entry : set) {
            @NonNull final ICoordinate source = entry.getKey();
            @NonNull final ICoordinate target = entry.getValue();
            final MavenProjectDto sourceRef = variables.get(source);
            final MavenProjectDto targetRef = variables.get(target);
            if (sourceRef == null) continue;
            if (targetRef == null) continue;

            @NonNull String protocol = targetRef.protocol();

            if (sourceRef.packaging().startsWith("User")) {
                if (!sourceRef.protocol().isEmpty()) {
                    protocol = sourceRef.protocol();
                }
            }

            stringBuilder
                    .append("Rel(")
                    .append(sourceRef.url()).append(", ")
                    .append(targetRef.url()).append(", ")
                    .append("\"").append(protocol).append("\"")
                    .append(")").append("\n");
        }
    }

    private void renderComponent(
            @NonNull final String component,
            @NonNull final StringBuilder stringBuilder,
            @NonNull final MavenProjectDto mavenProjectDto,
            @NonNull final Map<ICoordinate, MavenProjectDto> variables
    ) {
        @NonNull final List<Environment> environments = boundaries(mavenProjectDto.dependencies());
        startBoundary(stringBuilder, environments);
        for (int i = 0; i < environments.size(); i++) stringBuilder.append("\t");
        @NonNull final String url = mavenProjectDto.url();
        @NonNull final String name = mavenProjectDto.name();
        String scope = root().scope(mavenProjectDto);
        if (scope == null) scope = "compile";
        String componentName = component;
        String tags = "";
        if ("provided".equals(scope)) componentName += "_Ext";
        if ("compile".equals(scope)) tags = "selected";
        stringBuilder.append(renderComponent(componentName, url, name, "", "", tags));
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
        variables.put(new MavenCoordinateDto(mavenProjectDto), mavenProjectDto);
    }

}
