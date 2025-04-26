package ru.volnenko.plugin.arch.component.archapi.printer;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.builder.archapi.IRootBuilder;

public interface IRootPrinter {

    @NonNull
    IRootBuilder root();

    @NonNull
    IRootPrinter yaml();

    @NonNull
    IRootPrinter json();

}
