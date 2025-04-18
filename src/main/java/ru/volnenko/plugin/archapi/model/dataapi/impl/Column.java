package ru.volnenko.plugin.archapi.model.dataapi.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.dataapi.IColumn;

@Getter
@Setter
@NoArgsConstructor
public final class Column implements IColumn {

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
    public IColumn id(String id) {
        return null;
    }

    @Override
    public IColumn name(String name) {
        return null;
    }

    @Override
    public IColumn description(String description) {
        return null;
    }

}
