package ru.volnenko.plugin.archapi.model.dataapi.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.dataapi.ITable;

@Getter
@Setter
@NoArgsConstructor
public final class Table implements ITable {

    private String id;

    private String name;

    private String description;

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public ITable id(final String id) {
        return null;
    }

    @Override
    public ITable name(final String name) {
        return null;
    }

    @Override
    public ITable description(final String description) {
        return null;
    }

}
