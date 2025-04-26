package ru.volnenko.plugin.arch.api.techapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.arch.api.techapi.builder.IToolBuilder;
import ru.volnenko.plugin.arch.api.techapi.builder.impl.TechBuilder;

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
