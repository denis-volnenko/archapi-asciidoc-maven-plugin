package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;

public interface IVersionBuilder extends IBasicBuilder {

    @NonNull
    IVersionBuilder version(String version);

}
