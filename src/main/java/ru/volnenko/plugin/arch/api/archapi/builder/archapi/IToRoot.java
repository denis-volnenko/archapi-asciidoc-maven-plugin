package ru.volnenko.plugin.arch.api.archapi.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.archapi.model.IRoot;

public interface IToRoot {

    @NonNull
    IRoot toRoot();

}
