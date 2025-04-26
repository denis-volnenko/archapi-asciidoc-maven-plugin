package ru.volnenko.plugin.arch.archapi.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.archapi.model.IRoot;

public interface IToRoot {

    @NonNull
    IRoot toRoot();

}
