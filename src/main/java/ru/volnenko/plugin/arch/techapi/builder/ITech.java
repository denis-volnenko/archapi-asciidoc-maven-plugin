package ru.volnenko.plugin.arch.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.techapi.ITechBuilder;

public interface ITech {

    @NonNull
    ITechBuilder tech();

}
