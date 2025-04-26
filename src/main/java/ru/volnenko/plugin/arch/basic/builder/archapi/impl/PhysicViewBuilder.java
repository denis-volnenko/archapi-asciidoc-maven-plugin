package ru.volnenko.plugin.arch.basic.builder.archapi.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.builder.archapi.IRootBuilder;
import ru.volnenko.plugin.arch.basic.builder.archapi.IPhysicViewBuilder;

public final class PhysicViewBuilder extends AbstractBuilder implements IPhysicViewBuilder {

    @NonNull
    private final IRootBuilder rootBuilder;

    public PhysicViewBuilder(@NonNull IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }
}
