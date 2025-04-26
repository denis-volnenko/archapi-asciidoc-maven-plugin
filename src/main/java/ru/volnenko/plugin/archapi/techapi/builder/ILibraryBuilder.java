package ru.volnenko.plugin.archapi.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IVersionBuilder;

public interface ILibraryBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    ILibraryBuilder id(String id);

    @NonNull
    @Override
    ILibraryBuilder name(String name);

    @NonNull
    @Override
    ILibraryBuilder description(String description);

    @NonNull
    @Override
    ILibraryBuilder version(String version);

}
