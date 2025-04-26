package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.IBasicReference;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractReference implements IBasicReference {

    @JsonProperty("$ref")
    private String reference;

    @Override
    public String reference() {
        return reference;
    }

    @Override
    public void reference(final String reference) {
        this.reference = reference;
    }

}
