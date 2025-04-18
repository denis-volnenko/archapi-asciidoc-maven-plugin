package ru.volnenko.plugin.archapi.model.dataapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class TableReference {

    @JsonProperty("$ref")
    private String reference;

}
