package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class SizingContainer extends AbstractModel {

    private SizingCpu cpu;

    private SizingRam ram;

    private SizingHdd hdd;

    private SizingScale scale;

    private ServiceReference serviceReference;

}
