package ru.volnenko.plugin.arch.basic.generator;

import lombok.NonNull;

public interface IGenerator {

    @NonNull
    String generate();

}
