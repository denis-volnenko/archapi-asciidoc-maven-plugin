package ru.volnenko.plugin.archapi.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IVersionBuilder;
import ru.volnenko.plugin.archapi.builder.impl.VersionBuilder;
import ru.volnenko.plugin.archapi.techapi.model.impl.Tool;

public final class ToolBuilder extends VersionBuilder<Tool> {

    public ToolBuilder() {
        super(new Tool());
    }

    @NonNull
    @Override
    public ToolBuilder id(String id) {
         super.id(id);
         return this;
    }

    @NonNull
    @Override
    public ToolBuilder name(String name) {
        super.name(name);
        return this;
    }

    @NonNull
    @Override
    public ToolBuilder description(String description) {
        super.description(description);
        return this;
    }

    @NonNull
    @Override
    public IVersionBuilder version(String version) {
        super.version(version);
        return this;
    }
}
