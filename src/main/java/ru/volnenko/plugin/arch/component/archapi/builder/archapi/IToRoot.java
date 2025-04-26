package ru.volnenko.plugin.arch.component.archapi.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.model.IRoot;

public interface IToRoot {

    @NonNull
    IRoot toRoot();

}
