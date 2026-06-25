package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.model.impl.Components;
import ru.volnenko.plugin.arch.model.impl.Service;
import ru.volnenko.plugin.arch.model.impl.User;

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
                stringBuilder.append(renderUser(user.getUrl(), user.getName(), "", "", ""));
            }
        }

        if (components.getServices() != null) {
            for (final Service service : components.getServices().values()) {
                stringBuilder.append(renderApp("Container", service.getUrl(),  service.getDescription(), "", service.getName(), ""));
            }
        }

        if (components.getSystems() != null) {
            for (final ru.volnenko.plugin.arch.model.impl.System system: components.getSystems().values()) {
                stringBuilder.append(renderApp("System", system.getUrl(),  system.getDescription(), "", system.getName(), ""));
            }
        }

        return stringBuilder.toString();
    }

    @NonNull
    private String renderUser(
            @NonNull final String constant,
            @NonNull final String name,
            @NonNull final String title,
            @NonNull final String subtitle,
            @NonNull final String tags
    ) {
        return new StringBuilder()
                .append("Person").append("(")
                .append(constant).append(", ")
                .append("\"").append(name).append("\"").append(", ")
                .append("\"").append(title).append("\"").append(", ")
                .append("\"").append(subtitle).append("\"").append(", ")
                .append("\"").append(tags).append("\"")
                .append(")").append("\n").append("\n").toString();
    }

    @NonNull
    private String renderApp(
            @NonNull final String component,
            @NonNull final String constant,
            @NonNull final String name,
            @NonNull final String title,
            @NonNull final String subtitle,
            @NonNull final String tags
    ) {
        return new StringBuilder()
                .append(component)
                .append("(").append(constant).append(", ")
                .append("\"").append(name).append("\"").append(", ")
                .append("\"").append(title).append("\"").append(", ")
                .append("\"").append(subtitle).append("\"").append(", ")
                .append("\"").append(tags).append("\"")
                .append(")").append("\n").append("\n").toString();
    }

}
