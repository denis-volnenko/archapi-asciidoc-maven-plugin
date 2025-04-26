package ru.volnenko.plugin.arch.archapi.builder.archapi;

import lombok.NonNull;

public interface IComponentsBuilder extends IToRoot {

    @NonNull
    IRootBuilder root();

}
