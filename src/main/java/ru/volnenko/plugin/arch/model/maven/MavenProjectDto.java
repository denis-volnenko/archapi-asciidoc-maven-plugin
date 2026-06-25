package ru.volnenko.plugin.arch.model.maven;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenProjectDto implements Comparable<MavenProjectDto> {

    private String groupId = "";

    private String artifactId = "";

    private String version = "";

    private String url = "";

    private String name = "";

    private String description = "";

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

}
