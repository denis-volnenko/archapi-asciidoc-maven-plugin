package ru.volnenko.plugin.arch.model.maven;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.maven.model.Dependency;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenDependencyDto {

    private String groupId;

    private String artifactId;

    private String version;

    private String type;

    private String scope;

    public MavenDependencyDto(Dependency dependency) {
        groupId = dependency.getGroupId();
        artifactId = dependency.getArtifactId();
        version = dependency.getVersion();
        type = dependency.getType();
        scope = dependency.getScope();
    }

}
