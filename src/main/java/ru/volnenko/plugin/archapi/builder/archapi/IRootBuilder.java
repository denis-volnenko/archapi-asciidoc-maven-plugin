package ru.volnenko.plugin.archapi.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.IRoot;
import ru.volnenko.plugin.archapi.printer.IRootPrinter;

public interface IRootBuilder extends IToRoot {

    @NonNull
    IRootBuilder archapi(@NonNull String archapi);

    @NonNull
    IRootBuilder title(@NonNull String title);

    @NonNull
    IRootBuilder description(@NonNull String description);

    @NonNull
    IComponentsBuilder components();

    @NonNull
    IContextViewBuilder contextView();

    @NonNull
    ILogicViewBuilder logicView();

    @NonNull
    IPhysicViewBuilder physicView();

    @NonNull
    IRootBuilder root();

    @NonNull
    IRoot toRoot();

    @NonNull
    IRootPrinter printer();

    @NonNull
    String yaml();

    @NonNull
    String json();


}
