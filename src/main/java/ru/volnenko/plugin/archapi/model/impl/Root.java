package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IRoot;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public final class Root extends AbstractModel implements IRoot {

    private String archapi = "1.0.0";

    private String title = "";

    private String description = "";

    private ContextView contextView = new ContextView();

    private LogicView logicView = new LogicView();

    private PhysicView physicView = new PhysicView();

    private Map<String, Sizing> sizing = new HashMap<>();

    private Components components = new Components();

}
