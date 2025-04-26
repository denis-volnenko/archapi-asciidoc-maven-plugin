package ru.volnenko.plugin.arch.basic.printer;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.builder.archapi.IRootBuilder;

public interface IRootPrinter {

    @NonNull
    IRootBuilder root();

    @NonNull
    IRootPrinter yaml();

    @NonNull
    IRootPrinter json();

}
