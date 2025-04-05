package ru.volnenko.plugin.archapi;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import ru.volnenko.plugin.archapi.generator.impl.RootBasicGenerator;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.COMPILE)
public class Generator extends AbstractMojo {

    @NonNull
    public static Generator create() {
        return new Generator();
    }

    @Getter
    @Setter
    @Parameter(property = "serviceName")
    public String serviceName = "Сервис";

    @Getter
    @Setter
    @Parameter(property = "headerFirstEnabled")
    public boolean headerFirstEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "headerSecondEnabled")
    public boolean headerSecondEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "tableOfContentsEnabled")
    public boolean tableOfContentsEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "contextViewEnabled")
    private boolean contextViewEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "logicViewEnabled")
    private boolean logicViewEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "physicViewEnabled")
    private boolean physicViewEnabled = true;

    @NonNull
    private final RootBasicGenerator rootBasicGenerator = new RootBasicGenerator();

    @Override
    @SneakyThrows
    public void execute() {
        System.out.println(rootBasicGenerator.generate());
    }

    public static void main(String[] args) {
        Generator.create().execute();
    }

}
