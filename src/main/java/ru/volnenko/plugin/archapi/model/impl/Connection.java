package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class Connection extends AbstractModel {

    private String type;

    private String name;

    private String description;

    private Integer port;

}
