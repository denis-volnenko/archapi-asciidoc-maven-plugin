package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IContextView;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class ContextView extends AbstractModel implements IContextView {

    private String title = "";

    private String description = "";

    private List<Note> notes = new ArrayList<>();

    @JsonProperty("environment")
    private EnvironmentReference environmentReference = new EnvironmentReference();

}
