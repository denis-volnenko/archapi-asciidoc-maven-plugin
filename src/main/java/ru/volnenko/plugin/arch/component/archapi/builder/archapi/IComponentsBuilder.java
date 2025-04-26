package ru.volnenko.plugin.arch.component.archapi.builder.archapi;

import lombok.NonNull;

public interface IComponentsBuilder extends IToRoot {

    @NonNull
    IRootBuilder root();

}
