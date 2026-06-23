package ru.volnenko.plugin.arch;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;
import ru.volnenko.plugin.arch.builder.MavenProjectBuilder;
import ru.volnenko.plugin.arch.generator.GeneratorArchdoc;
import ru.volnenko.plugin.arch.generator.GeneratorComponent;
import ru.volnenko.plugin.arch.generator.GeneratorVocabulary;
import ru.volnenko.plugin.arch.model.impl.Root;
import ru.volnenko.plugin.arch.util.MapperUtil;

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
    @Parameter(property = "archdocEnabled")
    private boolean archdocEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "archdocFilename")
    private String archdocFilename = "src/main/asciidoc/archdoc.adoc";

    @Getter
    @Setter
    @Parameter(property = "contextViewEnabled")
    private boolean contextViewEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "contextViewDocumentFilename")
    private String contextViewDocumentFilename = "src/main/asciidoc/include/contextView.adoc";

    @Getter
    @Setter
    @Parameter(property = "contextViewDiagramFilename")
    private String contextViewDiagramFilename = "src/main/asciidoc/images/contextView.puml";

    @Getter
    @Setter
    @Parameter(property = "logicViewEnabled")
    private boolean logicViewEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "vocabularyEnabled")
    private boolean vocabularyEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "vocabularyDocumentFilename")
    private String vocabularyDocumentFilename = "src/main/asciidoc/include/vocabulary.adoc";

    @Getter
    @Setter
    @Parameter(property = "componentsEnabled")
    private boolean componentsEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "componentsDocumentFilename")
    private String componentsDocumentFilename = "src/main/asciidoc/include/components.adoc";

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Parameter(defaultValue = "${settings}", required = true, readonly = true)
    private Settings settings;

    @Override
    @SneakyThrows
    public void execute() {
        @NonNull final MavenProjectBuilder mavenProjectBuilder = new MavenProjectBuilder(settings);
        @NonNull final String yaml = mavenProjectBuilder.yaml(project);
        @NonNull final Root root = MapperUtil.yaml().readValue(yaml, Root.class);

        GeneratorVocabulary.create()
                .root(root)
                .enabled(vocabularyEnabled)
                .filename(vocabularyDocumentFilename)
                .execute();

        GeneratorComponent.create()
                .root(root)
                .enabled(componentsEnabled)
                .filename(componentsDocumentFilename)
                .execute();

        GeneratorArchdoc.create()
                .root(root)
                .enabled(archdocEnabled)
                .filename(archdocFilename)
                .execute();
    }

    public static void main(String[] args) {
        Generator.create().execute();
    }

}
