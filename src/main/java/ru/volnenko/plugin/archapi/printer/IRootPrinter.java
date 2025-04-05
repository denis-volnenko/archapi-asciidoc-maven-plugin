package ru.volnenko.plugin.archapi.printer;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.builder.IRootBuilder;

public interface IRootPrinter {

    @NonNull
    IRootBuilder root();

    @NonNull
    IRootPrinter yaml();

    @NonNull
    IRootPrinter json();

}
