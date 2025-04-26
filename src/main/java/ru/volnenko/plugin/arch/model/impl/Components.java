package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.component.dataapi.model.IColumn;
import ru.volnenko.plugin.arch.component.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.component.dataapi.model.ITable;
import ru.volnenko.plugin.arch.component.techapi.model.*;
import ru.volnenko.plugin.arch.model.IComponents;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Components implements IComponents {

    private Map<String, IFramework> frameworks = new LinkedHashMap<>();

    private Map<String, ILanguage> languages = new LinkedHashMap<>();

    private Map<String, ILibrary> libraries = new LinkedHashMap<>();

    private Map<String, IPlatform> platforms = new LinkedHashMap<>();

    private Map<String, ITool> tools = new LinkedHashMap<>();

    private Map<String, IDataBase> dataBases = new LinkedHashMap<>();

    private Map<String, ITable> tables = new LinkedHashMap<>();

    private Map<String, IColumn> columns = new LinkedHashMap<>();

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

    @NonNull
    @Override
    public Map<String, IColumn> columns() {
        return columns;
    }

    @NonNull
    @Override
    public Map<String, IDataBase> databases() {
        return dataBases;
    }

    @NonNull
    @Override
    public Map<String, ITable> tables() {
        return tables;
    }
}
