package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IContextView;

@Getter
@Setter
@NoArgsConstructor
public final class ContextView implements IContextView {

    private String title = "";

    private String description = "";

    @JsonProperty("environment")
    private EnvironmentReference environmentReference = new EnvironmentReference();

}
