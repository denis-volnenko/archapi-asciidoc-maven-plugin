package ru.volnenko.plugin.arch.archapi.model;

import ru.volnenko.plugin.arch.archapi.model.archapi.impl.Components;

public interface IRoot {

    Components getComponents();

    void setComponents(Components components);

}
