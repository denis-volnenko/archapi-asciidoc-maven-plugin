package ru.volnenko.plugin.arch;

import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import ru.volnenko.plugin.arch.util.FileUtil;

@Mojo(name = "reformat")
public final class Reformat extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    @SneakyThrows
    public void execute() {
        FileUtil.reformat(project.getFile());
    }

}
