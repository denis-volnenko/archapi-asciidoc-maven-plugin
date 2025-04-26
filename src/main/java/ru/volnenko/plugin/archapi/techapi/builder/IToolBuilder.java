package ru.volnenko.plugin.archapi.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IVersionBuilder;

public interface IToolBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    IToolBuilder id(String id);

    @NonNull
    @Override
    IToolBuilder name(String name);

    @NonNull
    @Override
    IToolBuilder description(String description);

    @NonNull
    @Override
    IVersionBuilder version(String version);

}
