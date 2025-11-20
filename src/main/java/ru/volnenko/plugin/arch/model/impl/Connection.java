package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Connection extends AbstractEnvironmentModel {

    private int port;

    private Reference protocol;

    private Source source;

    private Target target;

    private ConnectionLayout layout;

}
