package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.component.techapi.ITechComponents;
import ru.volnenko.plugin.arch.component.techapi.model.*;

import java.util.Collections;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Components implements ITechComponents {

    private Map<String, IFramework> frameworks;

    private Map<String, ILanguage> languages;

    private Map<String, ILibrary> libraries;

    private Map<String, IPlatform> platforms;

    private Map<String, ITool> tools;

    @NonNull
    @Override
    public Map<String, IFramework> frameworks() {
        if (frameworks == null) return Collections.emptyMap();
        return frameworks;
    }

    @NonNull
    @Override
    public Map<String, ILanguage> languages() {
        if (languages == null) return Collections.emptyMap();
        return languages;
    }

    @NonNull
    @Override
    public Map<String, ILibrary> libraries() {
        if (libraries == null) return Collections.emptyMap();
        return libraries;
    }

    @NonNull
    @Override
    public Map<String, IPlatform> platforms() {
        if (platforms == null) return Collections.emptyMap();
        return platforms;
    }

    @NonNull
    @Override
    public Map<String, ITool> tools() {
        if (tools == null) return Collections.emptyMap();
        return tools;
    }

}
