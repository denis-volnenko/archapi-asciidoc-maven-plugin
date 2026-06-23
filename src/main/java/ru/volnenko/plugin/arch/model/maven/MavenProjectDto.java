package ru.volnenko.plugin.arch.model.maven;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenProjectDto {

    private String groupId;

    private String artifactId;

    private String version;

    private String url;

    private String name;

    private String description;

    private Map<String, String> properties;

    private List<MavenDependencyDto> dependencies;

}
