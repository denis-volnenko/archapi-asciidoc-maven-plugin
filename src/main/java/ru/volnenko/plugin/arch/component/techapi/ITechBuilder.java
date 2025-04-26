package ru.volnenko.plugin.arch.component.techapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.builder.IFrameworkBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.ILanguageBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.ILibraryBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.IToolBuilder;
import ru.volnenko.plugin.arch.component.techapi.builder.impl.TechBuilder;

public interface ITechBuilder {

    @NonNull
    static ITechBuilder create() {
        return new TechBuilder();
    }

    @NonNull
    ILibraryBuilder library();

    @NonNull
    IToolBuilder tool();

    @NonNull
    IFrameworkBuilder framework();

    @NonNull
    ILanguageBuilder language();

}
