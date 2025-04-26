package ru.volnenko.plugin.arch.builder;

import org.junit.Test;
import ru.volnenko.plugin.arch.api.archapi.builder.archapi.impl.RootBuilder;

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
