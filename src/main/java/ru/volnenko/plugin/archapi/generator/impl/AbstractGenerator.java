package ru.volnenko.plugin.archapi.generator.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.generator.IGenerator;

public abstract class AbstractGenerator implements IGenerator {

    @NonNull
    @Override
    public String generate() {
        return "";
    }

}
