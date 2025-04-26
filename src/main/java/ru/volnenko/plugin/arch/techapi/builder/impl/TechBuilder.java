package ru.volnenko.plugin.arch.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.techapi.ITechBuilder;
import ru.volnenko.plugin.arch.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.arch.techapi.builder.IToolBuilder;

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

}
