package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class SizingCpu extends AbstractModel {

    private Integer value;

    private UnitCpu units;

}
