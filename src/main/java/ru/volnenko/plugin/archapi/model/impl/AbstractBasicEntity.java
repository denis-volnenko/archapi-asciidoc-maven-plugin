package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IBasicEntity;

@Getter
@Setter
public abstract class AbstractBasicEntity implements IBasicEntity {

    private String id;

    private String name;

    private String description;

    @Override
    public String description() {
        return description;
    }

    @Override
    public void description(final String description) {
        this.description = description;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public void id(String id) {
        this.id = id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void name(String name) {
        this.name = name;
    }

}
