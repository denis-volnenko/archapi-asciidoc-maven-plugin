package ru.volnenko.plugin.archapi.basic.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.model.IRoot;

public interface IToRoot {

    @NonNull
    IRoot toRoot();

}
