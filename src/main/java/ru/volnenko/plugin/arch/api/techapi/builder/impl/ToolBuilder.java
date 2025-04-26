package ru.volnenko.plugin.arch.api.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.techapi.ITechBuilder;
import ru.volnenko.plugin.arch.api.techapi.builder.IToolBuilder;
import ru.volnenko.plugin.arch.api.techapi.model.impl.Tool;
import ru.volnenko.plugin.arch.builder.IVersionBuilder;

public final class ToolBuilder extends AbstractITechBuilder<Tool> implements IToolBuilder {

    public ToolBuilder(@NonNull ITechBuilder techBuilder) {
        super(new Tool(), techBuilder);
    }

    @NonNull
    @Override
    public ToolBuilder id(@NonNull final String id) {
         super.id(id);
         return this;
    }

    @NonNull
    @Override
    public ToolBuilder name(@NonNull final String name) {
        super.name(name);
        return this;
    }

    @NonNull
    @Override
    public ToolBuilder description(@NonNull final String description) {
        super.description(description);
        return this;
    }

    @NonNull
    @Override
    public IVersionBuilder version(@NonNull final String version) {
        super.version(version);
        return this;
    }

}
