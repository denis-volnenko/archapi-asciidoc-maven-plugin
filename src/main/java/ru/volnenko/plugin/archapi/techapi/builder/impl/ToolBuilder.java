package ru.volnenko.plugin.archapi.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IVersionBuilder;
import ru.volnenko.plugin.archapi.techapi.ITechBuilder;
import ru.volnenko.plugin.archapi.techapi.builder.IToolBuilder;
import ru.volnenko.plugin.archapi.techapi.model.impl.Tool;

public final class ToolBuilder extends AbstractITechBuilder<Tool> implements IToolBuilder {

    public ToolBuilder(@NonNull ITechBuilder techBuilder) {
        super(new Tool(), techBuilder);
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
