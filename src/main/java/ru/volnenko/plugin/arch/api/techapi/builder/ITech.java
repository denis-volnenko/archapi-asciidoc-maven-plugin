package ru.volnenko.plugin.arch.api.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.techapi.ITechBuilder;

public interface ITech {

    @NonNull
    ITechBuilder tech();

}
