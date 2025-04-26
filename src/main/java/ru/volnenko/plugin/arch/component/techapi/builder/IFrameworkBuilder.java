package ru.volnenko.plugin.arch.component.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.builder.IVersionBuilder;

public interface IFrameworkBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    IFrameworkBuilder id(@NonNull String id);

    @NonNull
    @Override
    IFrameworkBuilder name(@NonNull String name);

    @NonNull
    @Override
    IFrameworkBuilder description(@NonNull String description);

    @NonNull
    @Override
    IFrameworkBuilder version(@NonNull String version);

}
