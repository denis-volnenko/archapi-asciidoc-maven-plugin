package ru.volnenko.plugin.archapi.basic.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.builder.archapi.IArchApiBuilder;
import ru.volnenko.plugin.archapi.basic.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.archapi.basic.builder.techapi.ITechApiBuilder;

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
