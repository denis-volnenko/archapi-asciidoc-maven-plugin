package ru.volnenko.plugin.arch.component.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.ITechBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.ILanguageBuilder;
import ru.volnenko.plugin.arch.component.techapi.model.IFramework;
import ru.volnenko.plugin.arch.component.techapi.model.impl.Framework;

public final class LanguageBuilder extends AbstractITechBuilder<IFramework> implements ILanguageBuilder {

    public LanguageBuilder(@NonNull final ITechBuilder techBuilder) {
        super(new Framework(), techBuilder);
    }

    @NonNull
    @Override
    public ILanguageBuilder id(@NonNull final String id) {
        super.id(id);
        return this;
    }

    @NonNull
    @Override
    public ILanguageBuilder name(@NonNull final String name) {
        super.name(name);
        return this;
    }

    @NonNull
    @Override
    public ILanguageBuilder description(@NonNull final String description) {
        super.description(description);
        return this;
    }

    @NonNull
    @Override
    public ILanguageBuilder version(@NonNull final String version) {
        super.version(version);
        return this;
    }

}
