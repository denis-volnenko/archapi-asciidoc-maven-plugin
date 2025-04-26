package ru.volnenko.plugin.arch.component.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.arch.component.techapi.ITechBuilder;
import ru.volnenko.plugin.arch.component.techapi.model.ILibrary;
import ru.volnenko.plugin.arch.component.techapi.model.impl.Library;

public final class LibraryBuilder extends AbstractITechBuilder<ILibrary> implements ILibraryBuilder {

    public LibraryBuilder(@NonNull ITechBuilder techBuilder) {
        super(new Library(), techBuilder);
    }

    @NonNull
    @Override
    public ILibraryBuilder id(@NonNull final String id) {
        super.id(id);
        return this;
    }

    @NonNull
    @Override
    public ILibraryBuilder name(@NonNull final String name) {
        super.name(name);
        return this;
    }

    @NonNull
    @Override
    public ILibraryBuilder description(@NonNull final String description) {
        super.description(description);
        return this;
    }

    @NonNull
    @Override
    public ILibraryBuilder version(@NonNull final String version) {
         super.version(version);
        return this;
    }

}
