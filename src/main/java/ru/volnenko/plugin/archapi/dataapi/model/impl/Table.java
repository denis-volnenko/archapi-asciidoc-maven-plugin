package ru.volnenko.plugin.archapi.dataapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.archapi.dataapi.model.ITable;

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

    @NonNull
    @Override
    public ITable id(@NonNull final String id) {
        this.id = id;
        return this;
    }

    @NonNull
    @Override
    public ITable name(@NonNull final String name) {
        this.name = name;
        return this;
    }

    @NonNull
    @Override
    public ITable description(@NonNull final String description) {
        this.description = description;
        return this;
    }

}
