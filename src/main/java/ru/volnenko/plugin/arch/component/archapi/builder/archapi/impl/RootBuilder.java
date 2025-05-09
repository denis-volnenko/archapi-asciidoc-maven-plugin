package ru.volnenko.plugin.arch.component.archapi.builder.archapi.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.IComponentsBuilder;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.IPhysicViewBuilder;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.IRootBuilder;
import ru.volnenko.plugin.arch.archapi.builder.archapi.*;
import ru.volnenko.plugin.arch.component.archapi.model.IRoot;
import ru.volnenko.plugin.arch.component.archapi.model.archapi.Root;
import ru.volnenko.plugin.arch.printer.IRootPrinter;
import ru.volnenko.plugin.arch.printer.impl.RootPrinter;
import ru.volnenko.plugin.arch.util.MapperUtil;

@NoArgsConstructor
public final class RootBuilder extends AbstractBuilder implements IRootBuilder {

    @NonNull
    private final IRootPrinter rootPrinter = new RootPrinter(this);

    @NonNull
    private final IPhysicViewBuilder physicViewBuilder = new PhysicViewBuilder(this);

    @NonNull
    private Root root = new Root();

    @NonNull
    @Override
    public IRootBuilder archapi(@NonNull final String archapi) {
        this.root.setArchapi(archapi);
        return this;
    }

    @NonNull
    @Override
    public IRootBuilder title(@NonNull final String title) {
        this.root.setTitle(title);
        return this;
    }

    @NonNull
    @Override
    public IRootBuilder description(@NonNull final String description) {
        this.root.setDescription(description);
        return this;
    }

    @NonNull
    @Override
    public IComponentsBuilder components() {
        return new ComponentsBuilder(this);
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
