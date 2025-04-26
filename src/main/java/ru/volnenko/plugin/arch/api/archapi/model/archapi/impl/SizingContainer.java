package ru.volnenko.plugin.arch.api.archapi.model.archapi.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class SizingContainer extends AbstractModel {

    private SizingCpu cpu;

    private SizingRam ram;

    private SizingHdd hdd;

    private SizingScale scale;

    private ServiceReference serviceReference;

}
