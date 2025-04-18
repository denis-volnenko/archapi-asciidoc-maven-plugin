package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.archapi.IArchApiBuilder;
import ru.volnenko.plugin.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.archapi.builder.techapi.ITechApiBuilder;

public interface IGeneratorBuilder {

    @NonNull
    static IGeneratorBuilder create() {
        return GeneratorBuilder.create();
    }

    @NonNull
    IArchApiBuilder archapi();

    @NonNull
    ITechApiBuilder techapi();

    @NonNull
    IDataApiBuilder dataapi();

}
