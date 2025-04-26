package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;

public interface IBasicBuilder {

    @NonNull
    IBasicBuilder id(String id);

    @NonNull
    IBasicBuilder name(String name);

    @NonNull
    IBasicBuilder description(String description);

}
