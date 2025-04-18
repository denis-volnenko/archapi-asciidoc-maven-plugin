package ru.volnenko.plugin.archapi.model.archapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IRoot;
import ru.volnenko.plugin.archapi.model.impl.*;
import ru.volnenko.plugin.archapi.model.impl.ContextView;
import ru.volnenko.plugin.archapi.model.impl.LogicView;
import ru.volnenko.plugin.archapi.model.impl.PhysicView;
import ru.volnenko.plugin.archapi.model.impl.SecurityView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Root extends AbstractModel implements IRoot {

    private String archapi = "1.0.0";

    private String title = "";

    private String description = "";

    private Map<String, History> history = new LinkedHashMap<>();

    private Map<String, Glossary> glossary = new LinkedHashMap<>();

    private ru.volnenko.plugin.archapi.model.impl.ContextView contextView = new ContextView();

    private ru.volnenko.plugin.archapi.model.impl.LogicView logicView = new LogicView();

    private ru.volnenko.plugin.archapi.model.impl.PhysicView physicView = new PhysicView();

    private OperationView operationalView = new OperationView();

    private ru.volnenko.plugin.archapi.model.impl.SecurityView securityView = new SecurityView();

    private Map<String, Sizing> sizing = new HashMap<>();

    private Components components = new Components();

}
