package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.techapi.ITechComponents;
import ru.volnenko.plugin.arch.techapi.model.impl.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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
