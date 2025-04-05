package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;

public interface IComponentsBuilder extends IToRoot {

    @NonNull
    IRootBuilder root();

}
