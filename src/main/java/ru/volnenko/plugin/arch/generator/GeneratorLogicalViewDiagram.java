package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public final class GeneratorLogicalViewDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorLogicalViewDiagram create() {
        return new GeneratorLogicalViewDiagram();
    }

    @NonNull
    @Override
    public  String generate() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@startuml").append("\n");
        stringBuilder.append("!include base-library.puml").append("\n");
        stringBuilder.append("!include logical-view-include.puml").append("\n");
        stringBuilder.append("left to right direction").append("\n");
        stringBuilder.append("skinparam nodesep 50").append("\n");
        stringBuilder.append("skinparam ranksep 100").append("\n");
        stringBuilder.append("LOGICAL_VIEW()").append("\n").append("\n");
        stringBuilder.append("@enduml").append("\n");

//        @NonNull final SourceStringReader reader = new SourceStringReader(stringBuilder.toString());
//        @NonNull final FileOutputStream output = new FileOutputStream(new File(path.getAbsolutePath() + "/" + filename + ".svg"));
//        reader.generateImage(output, new FileFormatOption(FileFormat.SVG, false));

        return stringBuilder.toString();
    }

    @Override
    public boolean rewrite() {
        return false;
    }

}
