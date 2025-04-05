package ru.volnenko.plugin.archapi.builder.impl;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.plugin.archapi.builder.*;
import ru.volnenko.plugin.archapi.model.IRoot;
import ru.volnenko.plugin.archapi.model.impl.Root;
import ru.volnenko.plugin.archapi.printer.IRootPrinter;
import ru.volnenko.plugin.archapi.printer.impl.RootPrinter;
import ru.volnenko.plugin.archapi.util.MapperUtil;

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
    public IContextViewBuilder contextView() {
        return new ContextViewBuilder(this);
    }

    @NonNull
    @Override
    public ILogicViewBuilder logicView() {
        return new LogicViewBuilder(this);
    }

    @NonNull
    @Override
    public IPhysicViewBuilder physicView() {
        return physicViewBuilder;
    }

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
