package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public final class GeneratorContextViewDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorContextViewDiagram create() {
        return new GeneratorContextViewDiagram();
    }

    @NonNull
    @Override
    public String generate() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@startuml").append("\n");
        stringBuilder.append("!include base-library.puml").append("\n");
        stringBuilder.append("!include context-view-include.puml").append("\n");
        stringBuilder.append("left to right direction").append("\n");
        stringBuilder.append("skinparam nodesep 50").append("\n");
        stringBuilder.append("skinparam ranksep 100").append("\n");
        stringBuilder.append("CONTEXT_VIEW()").append("\n").append("\n");
        stringBuilder.append("@enduml").append("\n");
        return stringBuilder.toString();
    }

    @Override
    public boolean rewrite() {
        return false;
    }

}
