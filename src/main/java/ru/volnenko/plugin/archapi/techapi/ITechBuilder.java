package ru.volnenko.plugin.archapi.techapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.archapi.techapi.builder.IToolBuilder;
import ru.volnenko.plugin.archapi.techapi.builder.impl.TechBuilder;

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
