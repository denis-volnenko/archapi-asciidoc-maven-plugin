package ru.volnenko.plugin.archapi.techapi.builder;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.techapi.ITechBuilder;

public interface ITech {

    @NonNull
    ITechBuilder tech();

}
