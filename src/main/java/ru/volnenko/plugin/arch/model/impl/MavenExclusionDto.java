package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.IArtifactId;
import ru.volnenko.plugin.arch.model.IGroupId;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenExclusionDto implements IGroupId, IArtifactId {

    private String groupId = "";

    private String artifactId = "";

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

}
