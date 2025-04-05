package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.plugin.archapi.builder.IComponentsBuilder;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;
import ru.volnenko.plugin.archapi.model.IRoot;
import ru.volnenko.plugin.archapi.model.impl.Root;
import ru.volnenko.plugin.archapi.printer.IRootPrinter;
import ru.volnenko.plugin.archapi.printer.impl.RootPrinter;
import ru.volnenko.plugin.archapi.util.MapperUtil;

@NoArgsConstructor
public final class RootBuilder extends AbstractBuilder implements IRootBuilder {

    @NonNull
    private final IComponentsBuilder componentsBuilder = new ComponentsBuilder(this);

    @NonNull
    private final IRootPrinter rootPrinter = new RootPrinter(this);

    @NonNull
    private Root root = new Root();

    @NonNull
    @Override
    public IRootBuilder title(@NonNull final String title) {
        return this;
    }

    @NonNull
    @Override
    public IRootBuilder description(@NonNull final String description) {
        return this;
    }

    @NonNull
    @Override
    public IComponentsBuilder componentsBuilder() {
        return componentsBuilder;
    }

    @NonNull
    public static IRootBuilder create() {
        return new RootBuilder();
    }

    @NonNull
    @Override
    public IRootBuilder root() {
        return this;
    }

    @NonNull
    @Override
    public IRoot toRoot() {
        return root;
    }

    @NonNull
    @Override
    @SneakyThrows
    public String yaml() {
        return MapperUtil.yaml().writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }

    @NonNull
    @Override
    @SneakyThrows
    public String json() {
        return MapperUtil.json().writerWithDefaultPrettyPrinter().writeValueAsString(root);
    }

    @NonNull
    @Override
    public IRootPrinter printer() {
        return rootPrinter;
    }

}
