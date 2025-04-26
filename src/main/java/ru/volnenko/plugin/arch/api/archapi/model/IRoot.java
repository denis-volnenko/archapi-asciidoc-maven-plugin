package ru.volnenko.plugin.arch.api.archapi.model;

import ru.volnenko.plugin.arch.api.archapi.model.archapi.impl.Components;

public interface IRoot {

    Components getComponents();

    void setComponents(Components components);

}
