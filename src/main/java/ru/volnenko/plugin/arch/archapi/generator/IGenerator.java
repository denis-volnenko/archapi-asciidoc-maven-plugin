package ru.volnenko.plugin.arch.archapi.generator;

import lombok.NonNull;

public interface IGenerator {

    @NonNull
    String generate();

}
