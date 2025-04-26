package ru.volnenko.plugin.arch.component.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.ITechBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.IFrameworkBuilder;
import ru.volnenko.plugin.arch.component.techapi.model.IFramework;
import ru.volnenko.plugin.arch.component.techapi.model.impl.Framework;

public final class FrameworkBuilder extends AbstractITechBuilder<IFramework> implements IFrameworkBuilder {

    public FrameworkBuilder(@NonNull final ITechBuilder techBuilder) {
        super(new Framework(), techBuilder);
    }

    @NonNull
    @Override
    public IFrameworkBuilder id(@NonNull final String id) {
        super.id(id);
        return this;
    }

    @NonNull
    @Override
    public IFrameworkBuilder name(@NonNull final String name) {
        super.name(name);
        return this;
    }

    @NonNull
    @Override
    public IFrameworkBuilder description(@NonNull final String description) {
        super.description(description);
        return this;
    }

    @NonNull
    @Override
    public IFrameworkBuilder version(@NonNull final String version) {
        super.version(version);
        return this;
    }

}
