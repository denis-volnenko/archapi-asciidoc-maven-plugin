package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import ru.volnenko.plugin.arch.util.StringUtil;

import java.io.InputStream;

public class GeneratorLibraryDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorLibraryDiagram create() {
        return new GeneratorLibraryDiagram();
    }

    @NonNull
    @Override
    public String generate() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( resource("META-INF/plantuml/container.puml")).append("\n\n");
        stringBuilder.append( resource("META-INF/plantuml/main.puml")).append("\n\n");
        stringBuilder.append( resource("META-INF/plantuml/tags.puml"));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("META-INF/plantuml/main.puml");
        System.out.println(StringUtil.format(inputStream));
    }

}
