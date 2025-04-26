package ru.volnenko.plugin.arch.component.archapi.generator;

import lombok.NonNull;

public interface IGenerator {

    @NonNull
    String generate();

}
