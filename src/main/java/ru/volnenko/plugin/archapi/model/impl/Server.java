package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class Server extends AbstractModel {

    private String name;

    private String host;

    private String description;

    private List<Integer> ports;

}
