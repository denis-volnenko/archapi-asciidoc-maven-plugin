package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.ICoordinate;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenProjectDto implements Comparable<MavenProjectDto>, ICoordinate {

    private String groupId = "";

    private String artifactId = "";

    private String version = "";

    private String url = "";

    private String name = "";

    private String description = "";

    private String packaging = "";

    private Map<String, String> properties = new LinkedHashMap<>();

    private List<MavenDependencyDto> dependencies = new ArrayList<>();

    @NonNull
    public List<MavenDependencyDto> dependencies() {
        if (dependencies == null) dependencies = new ArrayList<>();
        return dependencies;
    }

    @NonNull
    public Map<String, String> properties() {
        if (properties == null) properties = new LinkedHashMap<>();
        return properties;
    }

    @Override
    public int compareTo(MavenProjectDto o) {
        return name.compareTo(o.getName());
    }

    @NonNull
    public ICoordinate coordinate() {
        return this;
    }

    @NonNull
    public String version() {
        if (version == null) return "";
        return version;
    }

    @NonNull
    public String groupId() {
        if (groupId == null) return "";
        return groupId;
    }

    @NonNull
    public String artifactId() {
        if (artifactId == null) return "";
        return artifactId;
    }

    @NonNull
    public String name() {
        if (name == null) return "";
        return name;
    }

    public String packaging() {
        if (packaging == null) return "";
        return packaging;
    }

    @NonNull
    public String description() {
        if (description == null) return "";
        return description;
    }

    @NonNull
    public String url() {
        if (url == null) return "";
        return url;
    }

    @NonNull
    public String subtitle() {
        if (properties == null) return "";
        final String value = properties.get("archapi.subtitle");
        if (value == null) return "";
        return value;
    }

    @NonNull
    public String title() {
        if (properties == null) return "";
        final String value = properties.get("archapi.title");
        if (value == null) return "";
        return properties.get("archapi.title");
    }

    @NonNull
    public String archapi() {
        if (properties == null) return "";
        final String value = properties.get("archapi.archapi");
        if (value == null) return "";
        return properties.get("archapi.archapi");
    }

    @NonNull
    public String type() {
        if (packaging == null || "pom".equals(packaging)) {
            if (properties == null) return "";
            final String value = properties.get("archapi.type");
            if (value == null) return "";
            return properties.get("archapi.type");
        }
        return packaging;
    }

    @NonNull
    public String subtype() {
        if (properties == null) return "";
        final String value = properties.get("archapi.subtype");
        if (value == null) return "";
        return properties.get("archapi.subtype");
    }

    @NonNull
    public String port() {
        if (properties == null) return "";
        final String value = properties.get("archapi.port");
        if (value == null) return "";
        return properties.get("archapi.port");
    }

    @NonNull
    public String protocol() {
        if (properties == null) return "";
        final String value = properties.get("archapi.protocol");
        if (value == null) return "";
        return properties.get("archapi.protocol");
    }

    @NonNull
    public String comment() {
        if (properties == null) return "";
        final String value = properties.get("archapi.comment");
        if (value == null) return "";
        return properties.get("archapi.comment");
    }

    public Boolean contextViewEnabled() {
        if (properties == null) return null;
        final String value = properties.get("archapi.context.view.enabled");
        if (value == null) return null;
        return properties.get("archapi.context.view.enabled").equals("true");
    }

    public Boolean logicalViewEnabled() {
        if (properties == null) return null;
        final String value = properties.get("archapi.logical.view.enabled");
        if (value == null) return null;
        return properties.get("archapi.logical.view.enabled").equals("true");
    }

}
