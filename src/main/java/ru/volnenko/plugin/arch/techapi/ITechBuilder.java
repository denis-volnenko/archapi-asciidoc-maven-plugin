package ru.volnenko.plugin.arch.techapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.arch.techapi.builder.IToolBuilder;
import ru.volnenko.plugin.arch.techapi.builder.impl.TechBuilder;

public interface ITechBuilder {

    @NonNull
    static ITechBuilder create() {
        return new TechBuilder();
    }

    @NonNull
    ILibraryBuilder library();

    @NonNull
    IToolBuilder tool();

}
