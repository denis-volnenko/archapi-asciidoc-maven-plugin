package ru.volnenko.plugin.archapi.basic.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.builder.archapi.IArchApiBuilder;
import ru.volnenko.plugin.archapi.basic.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.archapi.basic.builder.techapi.ITechApiBuilder;
import ru.volnenko.plugin.archapi.basic.model.archapi.Root;

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
