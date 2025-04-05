package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;

public interface IRootBuilder {

    @NonNull
    IComponentsBuilder componentsBuilder();

}
