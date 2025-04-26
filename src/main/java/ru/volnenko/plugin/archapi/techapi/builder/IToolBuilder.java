package ru.volnenko.plugin.archapi.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IVersionBuilder;

public interface IToolBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    IToolBuilder id(@NonNull String id);

    @NonNull
    @Override
    IToolBuilder name(@NonNull String name);

    @NonNull
    @Override
    IToolBuilder description(@NonNull String description);

    @NonNull
    @Override
    IVersionBuilder version(@NonNull String version);

}
