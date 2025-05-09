package ru.volnenko.plugin.arch.printer.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.IRootBuilder;
import ru.volnenko.plugin.arch.printer.IRootPrinter;

public final class RootPrinter implements IRootPrinter {

    @NonNull
    private final IRootBuilder rootBuilder;

    public RootPrinter(@NonNull final IRootBuilder rootBuilder) {
        this.rootBuilder = rootBuilder;
    }

    @NonNull
    @Override
    public IRootBuilder root() {
        return rootBuilder;
    }

    @NonNull
    @Override
    public IRootPrinter yaml() {
        System.out.println(rootBuilder.yaml());
        return this;
    }

    @NonNull
    @Override
    public IRootPrinter json() {
        System.out.println(rootBuilder.json());
        return this;
    }

}
