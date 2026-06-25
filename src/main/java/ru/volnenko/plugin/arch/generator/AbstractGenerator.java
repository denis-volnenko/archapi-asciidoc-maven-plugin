package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.codehaus.plexus.util.FileUtils;
import ru.volnenko.plugin.arch.model.impl.Root;
import ru.volnenko.plugin.arch.util.StringUtil;

import java.io.File;
import java.io.InputStream;

public abstract class AbstractGenerator {

    private boolean enabled = false;

    @NonNull
    private String filename = "file.adoc";

    @NonNull
    private Root root;

    @NonNull
    public Root root() {
        return root;
    }

    public boolean rewrite() {
        return true;
    }

    @NonNull
    public AbstractGenerator enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    @NonNull
    public AbstractGenerator filename(@NonNull final String filename) {
        this.filename = filename;
        return this;
    }

    @NonNull
    public AbstractGenerator root(@NonNull final Root root) {
        this.root = root;
        return this;
    }

    @SneakyThrows
    public void execute() {
        if (!enabled) return;
        @NonNull final File file = new File(filename);
        @NonNull final String parent = file.getParent();

        @NonNull final File path = new File(parent);
        path.mkdirs();

        if (!file.exists()) {
            file.createNewFile();
            FileUtils.fileWrite(file, generate());
        }

        if (rewrite()) FileUtils.fileWrite(file, generate());
    }

    @NonNull
    public abstract String generate();

    protected String resource(String name) {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name);
        return StringUtil.format(inputStream);
    }

}
