package ru.volnenko.plugin.arch.basic.model;

import ru.volnenko.plugin.arch.basic.model.archapi.impl.Components;

public interface IRoot {

    Components getComponents();

    void setComponents(Components components);

}
