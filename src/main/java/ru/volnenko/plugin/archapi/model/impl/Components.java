package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.Setter;
import ru.volnenko.plugin.archapi.techapi.ITechComponents;
import ru.volnenko.plugin.archapi.techapi.model.impl.*;

import java.util.Map;

@Getter
@Setter
public final class Components implements ITechComponents {

    private Map<String, Framework> frameworks;

    private Map<String, Language> languages;

    private Map<String, Library> libraries;

    private Map<String, Platform> platforms;

    private Map<String, Tool> tools;

    @Override
    public Map<String, Framework> frameworks() {
        return frameworks;
    }

    @Override
    public Map<String, Language> languages() {
        return languages;
    }

    @Override
    public Map<String, Library> libraries() {
        return libraries;
    }

    @Override
    public Map<String, Platform> platforms() {
        return platforms;
    }

    @Override
    public Map<String, Tool> tools() {
        return tools;
    }
}
