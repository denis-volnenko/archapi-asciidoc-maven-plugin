package ru.volnenko.plugin.arch.component.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.ITechBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.IFrameworkBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.ILanguageBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.IToolBuilder;

public final class TechBuilder implements ITechBuilder {

    @NonNull
    private final ITechBuilder techBuilder = this;

    @NonNull
    @Override
    public ILibraryBuilder library() {
        return new LibraryBuilder(techBuilder);
    }

    @NonNull
    @Override
    public IToolBuilder tool() {
        return new ToolBuilder(techBuilder);
    }

    @NonNull
    @Override
    public IFrameworkBuilder framework() {
        return new FrameworkBuilder(techBuilder);
    }

    @NonNull
    @Override
    public ILanguageBuilder language() {
        return new LanguageBuilder(techBuilder);
    }

}
