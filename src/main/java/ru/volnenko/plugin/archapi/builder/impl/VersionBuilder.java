package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IVersionBuilder;
import ru.volnenko.plugin.archapi.model.IBasicVersion;

public abstract class VersionBuilder<T extends IBasicVersion> extends BasicBuilder<T> implements IVersionBuilder {

    public VersionBuilder(@NonNull T entity) {
        super(entity);
    }

    @NonNull
    @Override
    public IVersionBuilder version(String version) {
        entity.version(version);
        return this;
    }

}
