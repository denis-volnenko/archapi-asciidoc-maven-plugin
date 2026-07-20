package ru.volnenko.plugin.arch;

import lombok.NonNull;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.COMPILE)
public final class Generator extends AbstractGenerator {

    @NonNull
    public static Generator create() {
        return new Generator();
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        generate();
    }

}
