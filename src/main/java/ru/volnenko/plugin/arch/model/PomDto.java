package ru.volnenko.plugin.arch.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PomDto {

    private String groupId;

    private String artifactId;

    private String version;

    private String type;

    private String name;

    private String description;

    private String url;

}
