package ru.volnenko.plugin.archapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.IRoot;

public interface IToRoot {

    @NonNull
    IRoot toRoot();

}
