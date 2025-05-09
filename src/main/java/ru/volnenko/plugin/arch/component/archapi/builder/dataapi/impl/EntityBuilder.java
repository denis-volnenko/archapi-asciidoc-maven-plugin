package ru.volnenko.plugin.arch.component.archapi.builder.dataapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.builder.dataapi.IDataApiBuilder;
import ru.volnenko.plugin.arch.component.archapi.builder.dataapi.IEntityBuilder;

public final class EntityBuilder implements IEntityBuilder {

    @NonNull
    private final IDataApiBuilder dataApiBuilder;

    public EntityBuilder(@NonNull final IDataApiBuilder dataApiBuilder) {
        this.dataApiBuilder = dataApiBuilder;
    }

}
