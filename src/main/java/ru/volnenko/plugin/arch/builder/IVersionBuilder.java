package ru.volnenko.plugin.arch.builder;

import lombok.NonNull;

public interface IVersionBuilder extends IBasicBuilder {

    @NonNull
    IVersionBuilder version(@NonNull String version);

}
