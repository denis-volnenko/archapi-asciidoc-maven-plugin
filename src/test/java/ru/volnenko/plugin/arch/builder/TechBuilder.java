package ru.volnenko.plugin.arch.builder;

import org.junit.Test;
import ru.volnenko.plugin.arch.component.techapi.ITechBuilder;

public class TechBuilder {

    @Test
    public void test() {
        ITechBuilder.create()
                .library().description("").id("").name("").tech()
                .tool().description("").id("").name("").tech()
                .language().description("").id("").name("").tech()
                .framework().description("").id("").name("").tech();
    }

}
