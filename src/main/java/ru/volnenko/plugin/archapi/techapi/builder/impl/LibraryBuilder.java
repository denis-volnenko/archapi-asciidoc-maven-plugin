package ru.volnenko.plugin.archapi.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.techapi.ITechBuilder;
import ru.volnenko.plugin.archapi.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.archapi.techapi.model.impl.Library;

public final class LibraryBuilder extends AbstractITechBuilder<Library> implements ILibraryBuilder {

    public LibraryBuilder(@NonNull ITechBuilder techBuilder) {
        super(new Library(), techBuilder);
    }

    @NonNull
    @Override
    public ILibraryBuilder id(String id) {
        super.id(id);
        return this;
    }

    @NonNull
    @Override
    public ILibraryBuilder name(String name) {
        super.name(name);
        return this;
    }

    @NonNull
    @Override
    public ILibraryBuilder description(String description) {
        super.description(description);
        return this;
    }

    @NonNull
    @Override
    public ILibraryBuilder version(String version) {
         super.version(version);
        return this;
    }

}
