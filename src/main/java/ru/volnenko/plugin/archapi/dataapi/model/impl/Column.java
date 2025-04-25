package ru.volnenko.plugin.archapi.dataapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.archapi.dataapi.model.IColumn;

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

    @NonNull
    @Override
    public IColumn id(String id) {
        return this;
    }

    @NonNull
    @Override
    public IColumn name(String name) {
        return this;
    }

    @NonNull
    @Override
    public IColumn description(String description) {
        return this;
    }

}
