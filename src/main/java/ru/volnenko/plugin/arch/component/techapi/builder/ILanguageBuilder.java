package ru.volnenko.plugin.arch.component.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.builder.IVersionBuilder;

public interface ILanguageBuilder extends IVersionBuilder, ITech {

    @NonNull
    @Override
    ILanguageBuilder id(@NonNull String id);

    @NonNull
    @Override
    ILanguageBuilder name(@NonNull String name);

    @NonNull
    @Override
    ILanguageBuilder description(@NonNull String description);

    @NonNull
    @Override
    ILanguageBuilder version(@NonNull String version);

}
