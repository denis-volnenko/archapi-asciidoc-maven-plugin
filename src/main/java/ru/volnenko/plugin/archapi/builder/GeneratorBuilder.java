package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.archapi.IArchApiBuilder;
import ru.volnenko.plugin.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.archapi.builder.techapi.ITechApiBuilder;

public final class GeneratorBuilder implements IGeneratorBuilder {

    @NonNull
    public static IGeneratorBuilder create() {
        return new GeneratorBuilder();
    }

    @NonNull
    @Override
    public IArchApiBuilder archapi() {
        return null;
    }

    @NonNull
    @Override
    public ITechApiBuilder techapi() {
        return null;
    }

    @NonNull
    @Override
    public IDataApiBuilder dataapi() {
        return null;
    }

}
