package ru.volnenko.plugin.arch.component.archapi.model;

import ru.volnenko.plugin.arch.component.archapi.model.archapi.impl.Components;

public interface IRoot {

    Components getComponents();

    void setComponents(Components components);

}
