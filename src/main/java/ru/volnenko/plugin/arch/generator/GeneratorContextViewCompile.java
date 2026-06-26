package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import lombok.SneakyThrows;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceFileReader;

import java.io.File;

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

    @SneakyThrows
    public void execute() {
        if (!enabled) return;
        @NonNull final File file = new File(source);
        @NonNull final FileFormatOption option = new FileFormatOption(FileFormat.SVG);
        @NonNull final SourceFileReader reader = new SourceFileReader(file, new File("."), option);
        reader.getGeneratedImages();
    }

}
