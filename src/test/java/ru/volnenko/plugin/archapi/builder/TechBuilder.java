package ru.volnenko.plugin.archapi.builder;

import org.junit.Test;
import ru.volnenko.plugin.archapi.techapi.ITechBuilder;

public class TechBuilder {

    @Test
    public void test() {
        ITechBuilder.create()
                .library().description("").id("").name("").tech()
                .tool().description("").id("").name("");
    }

}
