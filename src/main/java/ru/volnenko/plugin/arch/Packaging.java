package ru.volnenko.plugin.arch;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;
import ru.volnenko.plugin.arch.builder.MavenProjectBuilder;
import ru.volnenko.plugin.arch.component.PomDeployer;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Mojo(name = "package", defaultPhase = LifecyclePhase.PACKAGE)
public final class Packaging extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Parameter(defaultValue = "${settings}", required = true, readonly = true)
    private Settings settings;

    @Getter
    @Setter
    @Parameter(property = "archapiUrl", defaultValue = "http://localhost:8080")
    public String archapiUrl = "http://localhost:8080";

    @Getter
    @Setter
    @Parameter(property = "archapiEnabled", defaultValue = "false")
    public Boolean archapiEnabled = false;

    @NonNull
    @SneakyThrows
    private Model model() {
        final File pomFile = project.getFile();// Path to target pom.xml
        final MavenXpp3Reader reader = new MavenXpp3Reader();
        final Model model = reader.read(new FileReader(pomFile));
        return model;
    }

    @Override
    @SneakyThrows
    public void execute() {
        @NonNull final File buildPath = new File(project.getBuild().getDirectory());
        buildPath.mkdirs();


        @NonNull final String sourceName = project.getBuild().getFinalName() + "." + project.getPackaging();
        @NonNull final File build = new File(project.getBuild().getDirectory(), sourceName);

        final MavenProjectBuilder mavenProjectBuilder = new MavenProjectBuilder(settings);
        @NonNull final String yaml = mavenProjectBuilder.yaml(model());
        Files.write(build.toPath(), yaml.getBytes(StandardCharsets.UTF_8));

        @NonNull final Artifact artifact = project.getArtifact();
        artifact.setFile(build);

        PomDeployer.create()
                .archapiUrl(archapiUrl)
                .archapiEnabled(archapiEnabled)
                .mavenProject(project)
                .execute();
    }

}
