package ru.volnenko.plugin.arch.techapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.techapi.model.impl.*;

import java.util.Map;

public interface ITechComponents {

    @NonNull
    Map<String, Framework> frameworks();

    @NonNull
    Map<String, Language> languages();

    @NonNull
    Map<String, Library> libraries();

    @NonNull
    Map<String, Platform> platforms();

    @NonNull
    Map<String, Tool> tools();

}
