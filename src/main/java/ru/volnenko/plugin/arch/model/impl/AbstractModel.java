package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractModel implements Comparable<AbstractModel> {

    private String groupId;

    private String artifactId;

    private String name;

    private String description;

    @Override
    public int compareTo(AbstractModel o) {
        return name.compareTo(o.getName());
    }

}
