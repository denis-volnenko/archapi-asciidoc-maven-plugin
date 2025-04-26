package ru.volnenko.plugin.arch.builder;

import lombok.NonNull;

public interface IBasicBuilder {

    @NonNull
    IBasicBuilder id(@NonNull String id);

    @NonNull
    IBasicBuilder name(@NonNull String name);

    @NonNull
    IBasicBuilder description(@NonNull String description);

}
