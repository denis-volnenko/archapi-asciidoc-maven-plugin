package ru.volnenko.plugin.arch.component.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.builder.IVersionBuilder;

public interface IPlatformBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    IPlatformBuilder id(@NonNull String id);

    @NonNull
    @Override
    IPlatformBuilder name(@NonNull String name);

    @NonNull
    @Override
    IPlatformBuilder description(@NonNull String description);

    @NonNull
    @Override
    IPlatformBuilder version(@NonNull String version);

}
