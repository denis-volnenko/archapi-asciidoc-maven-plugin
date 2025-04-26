package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.api.techapi.ITechComponents;
import ru.volnenko.plugin.arch.api.techapi.model.impl.*;

import java.util.Collections;
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

    @NonNull
    @Override
    public Map<String, Framework> frameworks() {
        if (frameworks == null) return Collections.emptyMap();
        return frameworks;
    }

    @NonNull
    @Override
    public Map<String, Language> languages() {
        if (languages == null) return Collections.emptyMap();
        return languages;
    }

    @NonNull
    @Override
    public Map<String, Library> libraries() {
        if (libraries == null) return Collections.emptyMap();
        return libraries;
    }

    @NonNull
    @Override
    public Map<String, Platform> platforms() {
        if (platforms == null) return Collections.emptyMap();
        return platforms;
    }

    @NonNull
    @Override
    public Map<String, Tool> tools() {
        if (tools == null) return Collections.emptyMap();
        return tools;
    }

}
