package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IRoot;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class Root implements IRoot {

    private String archapi;

    private String title;

    private String description;

    private ContextView contextView;

    private LogicView logicView;

    private PhysicView physicView;

    private Map<String, Sizing> sizing;

    private Components components;

}
