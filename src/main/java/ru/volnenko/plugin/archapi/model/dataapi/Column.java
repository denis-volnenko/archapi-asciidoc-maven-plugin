package ru.volnenko.plugin.archapi.model.dataapi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class Column {

    private String id;

    private String name;

    private String description;

}
