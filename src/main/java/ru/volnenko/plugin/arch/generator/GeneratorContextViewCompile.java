package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;

public final class GeneratorContextViewCompile {

    private boolean enabled = false;

    @NonNull
    private String source = "";

    @NonNull
    private String target = "";

    @NonNull
    public static GeneratorContextViewCompile create() {
        return new GeneratorContextViewCompile();
    }

    @NonNull
    public GeneratorContextViewCompile source(@NonNull final String source) {
        this.source = source;
        return this;
    }

    @NonNull
    public GeneratorContextViewCompile target(@NonNull final String target) {
        this.target = target;
        return this;
    }

    @NonNull
    public GeneratorContextViewCompile enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public void execute() {

    }

}
