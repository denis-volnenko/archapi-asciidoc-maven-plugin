package ru.volnenko.plugin.arch.basic.builder.archapi;

import lombok.NonNull;

public interface IComponentsBuilder extends IToRoot {

    @NonNull
    IRootBuilder root();

}
