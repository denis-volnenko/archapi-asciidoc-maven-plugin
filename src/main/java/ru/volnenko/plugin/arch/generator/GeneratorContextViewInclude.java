package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.ICoordinate;
import ru.volnenko.plugin.arch.model.impl.Environment;
import ru.volnenko.plugin.arch.model.impl.Service;
import ru.volnenko.plugin.arch.model.impl.User;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class GeneratorContextViewInclude extends AbstractGenerator {

    @NonNull
    public static GeneratorContextViewInclude create() {
        return new GeneratorContextViewInclude();
    }


    @NonNull
    @Override
    public String generate() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        @NonNull final Map<ICoordinate, MavenProjectDto> variables = new LinkedHashMap<>();

        for (@NonNull final User user : root().users()) {
           renderUser(stringBuilder, user, variables, user.contextViewEnabled());
        }

        for (@NonNull final Service item :  root().services()) {
            renderComponent("Container", stringBuilder, item);
        }

        for (@NonNull final ru.volnenko.plugin.arch.model.impl.System item: root().systems()) {
            renderComponent("System", stringBuilder, item);
        }

        @NonNull final String result = stringBuilder.toString();
        if (result.isEmpty()) stringBuilder.append("\n\n");

        return result;
    }

    private void renderComponent(
            @NonNull final String component,
            @NonNull final StringBuilder stringBuilder,
            @NonNull final MavenProjectDto mavenProjectDto
    ) {
        final Boolean contextViewEnabled = mavenProjectDto.contextViewEnabled();
        if (contextViewEnabled != null && !contextViewEnabled) return;

        @NonNull final List<Environment> environments = boundaries(mavenProjectDto.dependencies());
        startBoundary(stringBuilder, environments);
        for (int i = 0; i < environments.size(); i++) stringBuilder.append("\t");
        @NonNull final String url = mavenProjectDto.url();
        @NonNull final String description = mavenProjectDto.description();
        @NonNull String name = mavenProjectDto.name();
        if (name.equals(description)) name = "";
        String scope = root().scope(mavenProjectDto);
        if (scope == null) scope = "compile";
        String componentName = component;
        String tags = "";
        if ("provided".equals(scope)) componentName += "_Ext";
        if ("compile".equals(scope)) tags = "selected";
        stringBuilder.append(renderComponent(componentName, url, description, "", name, tags));
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
    }

}
