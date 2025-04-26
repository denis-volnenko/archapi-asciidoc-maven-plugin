package ru.volnenko.plugin.arch.techapi;

import ru.volnenko.plugin.arch.techapi.model.impl.*;

import java.util.Map;

public interface ITechComponents {

    Map<String, Framework> frameworks();

    Map<String, Language> languages();

    Map<String, Library> libraries();

    Map<String, Platform> platforms();

    Map<String, Tool> tools();

}
