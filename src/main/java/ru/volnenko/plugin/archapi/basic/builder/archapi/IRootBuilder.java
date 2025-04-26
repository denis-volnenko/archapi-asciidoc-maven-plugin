package ru.volnenko.plugin.archapi.basic.builder.archapi;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.model.IRoot;
import ru.volnenko.plugin.archapi.basic.printer.IRootPrinter;

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
