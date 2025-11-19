package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class EnvironmentReference {

    @JsonProperty("$ref")
    private String reference;

}
