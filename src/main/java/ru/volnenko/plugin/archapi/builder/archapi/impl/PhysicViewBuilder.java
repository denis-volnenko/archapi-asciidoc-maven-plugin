package ru.volnenko.plugin.archapi.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.archapi.IPhysicViewBuilder;
import ru.volnenko.plugin.archapi.builder.archapi.IRootBuilder;

public final class PhysicViewBuilder extends AbstractBuilder implements IPhysicViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public PhysicViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }
}
