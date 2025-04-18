package ru.volnenko.plugin.archapi.builder.archapi;

import lombok.NonNull;

public interface IComponentsBuilder extends IToRoot {

    @NonNull
    IRootBuilder root();

}
