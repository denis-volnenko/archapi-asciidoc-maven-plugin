package ru.volnenko.plugin.arch.component.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.ITechBuilder;

public interface ITech {

    @NonNull
    ITechBuilder tech();

}
