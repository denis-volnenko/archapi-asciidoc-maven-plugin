package ru.volnenko.plugin.arch.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class LogicView extends AbstractModel {

    private String title = "Логическое представление (Logic View)";

    private String description = "";

    private List<Link> links = new ArrayList<>();

    private List<Note> notes = new ArrayList<>();

    @JsonProperty("environment")
    private EnvironmentReference environmentReference = new EnvironmentReference();

}
