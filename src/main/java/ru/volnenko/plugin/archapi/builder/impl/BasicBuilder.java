package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IBasicBuilder;
import ru.volnenko.plugin.archapi.model.IBasicEntity;

public class BasicBuilder implements IBasicBuilder {

    private IBasicEntity entity;

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

}
