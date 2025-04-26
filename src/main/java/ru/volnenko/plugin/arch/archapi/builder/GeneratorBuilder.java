package ru.volnenko.plugin.arch.archapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.archapi.builder.archapi.IArchApiBuilder;
import ru.volnenko.plugin.arch.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.arch.archapi.builder.techapi.ITechApiBuilder;
import ru.volnenko.plugin.arch.archapi.model.archapi.Root;

public final class GeneratorBuilder implements IGeneratorBuilder {

    @NonNull
    private Root root = new Root();

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
