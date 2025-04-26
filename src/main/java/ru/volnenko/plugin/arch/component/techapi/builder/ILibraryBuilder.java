package ru.volnenko.plugin.arch.component.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.builder.IVersionBuilder;

public interface ILibraryBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    ILibraryBuilder id(@NonNull String id);

    @NonNull
    @Override
    ILibraryBuilder name(@NonNull String name);

    @NonNull
    @Override
    ILibraryBuilder description(@NonNull String description);

    @NonNull
    @Override
    ILibraryBuilder version(@NonNull String version);

}
