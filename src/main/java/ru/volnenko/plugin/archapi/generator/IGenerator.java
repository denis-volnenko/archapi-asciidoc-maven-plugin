package ru.volnenko.plugin.archapi.generator;

import lombok.NonNull;

public interface IGenerator {

    @NonNull
    String generate();

}
