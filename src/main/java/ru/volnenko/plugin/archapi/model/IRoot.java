package ru.volnenko.plugin.archapi.model;

import ru.volnenko.plugin.archapi.model.archapi.impl.Components;

public interface IRoot {

    Components getComponents();

    void setComponents(Components components);

}
