package ru.volnenko.plugin.arch.basic.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.model.IRoot;

public interface IToRoot {

    @NonNull
    IRoot toRoot();

}
