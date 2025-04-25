package ru.volnenko.plugin.archapi.basic.printer;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.builder.archapi.IRootBuilder;

public interface IRootPrinter {

    @NonNull
    IRootBuilder root();

    @NonNull
    IRootPrinter yaml();

    @NonNull
    IRootPrinter json();

}
