package ru.volnenko.plugin.arch.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.builder.IBasicBuilder;
import ru.volnenko.plugin.arch.model.IBasicEntity;

public abstract class BasicBuilder<T extends IBasicEntity> implements IBasicBuilder {

    protected T entity;

    public BasicBuilder(@NonNull T entity) {
        this.entity = entity;
    }

    @NonNull
    @Override
    public IBasicBuilder id(@NonNull String id) {
        entity.id(id);
        return this;
    }

    @NonNull
    @Override
    public IBasicBuilder name(@NonNull String name) {
        entity.name(name);
        return this;
    }

    @NonNull
    @Override
    public IBasicBuilder description(@NonNull String description) {
        entity.description(description);
        return this;
    }

    @NonNull
    public T toEntity() {
        return entity;
    }

}
