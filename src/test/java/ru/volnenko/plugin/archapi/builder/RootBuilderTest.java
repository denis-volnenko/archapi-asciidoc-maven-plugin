package ru.volnenko.plugin.archapi.builder;

import org.junit.Test;
import ru.volnenko.plugin.archapi.builder.archapi.impl.RootBuilder;

public class RootBuilderTest {

    @Test
    public void test() {
        RootBuilder.create()
                .components()
                .root()
                .printer()
                .yaml();
    }

}
