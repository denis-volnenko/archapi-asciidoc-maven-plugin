package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IPhysicViewBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;

public final class PhysicViewBuilder extends AbstractBuilder implements IPhysicViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public PhysicViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }
}
