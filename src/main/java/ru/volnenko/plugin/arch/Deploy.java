package ru.volnenko.plugin.arch;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import ru.volnenko.plugin.arch.component.PomDeployer;


@Mojo(name = "deploy", defaultPhase = LifecyclePhase.PACKAGE)
public final class Deploy extends AbstractGenerator {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Getter
    @Setter
    @Parameter(property = "archapiUrl", defaultValue = "http://localhost:8080")
    public String archapiUrl = "http://localhost:8080";

    @Getter
    @Setter
    @Parameter(property = "archapiEnabled", defaultValue = "false")
    public Boolean archapiEnabled = false;

    @Override
    @SneakyThrows
    public void execute() {
        PomDeployer.create()
                .archapiUrl(archapiUrl)
                .archapiEnabled(archapiEnabled)
                .mavenProject(project)
                .execute();
    }

}
