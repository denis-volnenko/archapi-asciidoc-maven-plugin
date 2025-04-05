package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class Sizing extends AbstractModel {

    private EnvironmentReference reference;

    private String title = "";

    private String description = "";

    private List<SizingContainer> contarization = new ArrayList<>();

    private List<SizingVirtualMachine> virtualization = new ArrayList<>();

}
