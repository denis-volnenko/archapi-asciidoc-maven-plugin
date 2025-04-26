package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IBasicBuilder;
import ru.volnenko.plugin.archapi.model.IBasicEntity;

public abstract class BasicBuilder<T extends IBasicEntity> implements IBasicBuilder {

    protected T entity;

    public BasicBuilder(@NonNull T entity) {
        this.entity = entity;
    }

    @NonNull
    @Override
    public IBasicBuilder id(String id) {
        entity.id(id);
        return this;
    }

    @NonNull
    @Override
    public IBasicBuilder name(String name) {
        entity.name(name);
        return this;
    }

    @NonNull
    @Override
    public IBasicBuilder description(String description) {
        entity.description(description);
        return this;
    }

    @NonNull
    public T toEntity() {
        return entity;
    }

}
