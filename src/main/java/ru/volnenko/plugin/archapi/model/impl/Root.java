package ru.volnenko.plugin.archapi.model.impl;

import ru.volnenko.plugin.archapi.model.IRoot;

import java.util.Map;

public class Root implements IRoot {

    private String archapi;

    private String title;

    private String description;

    private ContextView contextView;

    private LogicView logicView;

    private PhysicView physicView;

    private Map<String, Sizing> sizing;

    private Components components;

}
