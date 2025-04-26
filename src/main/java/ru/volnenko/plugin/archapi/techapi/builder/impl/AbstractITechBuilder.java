package ru.volnenko.plugin.archapi.techapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.impl.VersionBuilder;
import ru.volnenko.plugin.archapi.model.IBasicVersion;
import ru.volnenko.plugin.archapi.techapi.ITechBuilder;
import ru.volnenko.plugin.archapi.techapi.builder.ITech;

public abstract class AbstractITechBuilder<T extends IBasicVersion> extends VersionBuilder<T> implements ITech {

    @NonNull
    private final ITechBuilder techBuilder;

    @NonNull
    @Override
    public ITechBuilder tech() {
        return techBuilder;
    }

    public AbstractITechBuilder(@NonNull T entity, @NonNull ITechBuilder techBuilder) {
        super(entity);
        this.techBuilder = techBuilder;
    }

}
