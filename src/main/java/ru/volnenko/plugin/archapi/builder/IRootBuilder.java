package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.IRoot;

public interface IRootBuilder {

    @NonNull
    IRootBuilder title(@NonNull String title);

    @NonNull
    IRootBuilder description(@NonNull String description);

    @NonNull
    IComponentsBuilder componentsBuilder();

    @NonNull
    IRootBuilder toRoot();

    @NonNull
    IRoot root();

    @NonNull
    String yaml();

    @NonNull
    String json();

}
