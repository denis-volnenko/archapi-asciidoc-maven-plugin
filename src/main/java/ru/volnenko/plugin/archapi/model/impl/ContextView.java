package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IContextView;
import ru.volnenko.plugin.archapi.model.archapi.View;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ContextView extends AbstractModel implements IContextView {

    private String title = "";

    private String description = "";

    private List<View> views = new ArrayList<>();

    private List<Link> links = new ArrayList<>();

    private List<Note> notes = new ArrayList<>();

    @JsonProperty("environment")
    private EnvironmentReference environmentReference = new EnvironmentReference();

}
