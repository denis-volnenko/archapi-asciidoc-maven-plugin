package ru.volnenko.plugin.archapi.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IBasicReference;

@Getter
@Setter
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
