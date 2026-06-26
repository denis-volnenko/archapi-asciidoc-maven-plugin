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
import ru.volnenko.plugin.arch.generator.*;
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
    @Parameter(property = "contextViewEnabled")
    private boolean contextViewEnabled = true;

    @NonNull
    private final String archdocFilename = "src/main/asciidoc/archdoc.adoc";

    @NonNull
    private final String contextViewDiagramFilename = "src/main/asciidoc/images/context-view.puml";

    @NonNull
    private final String logicalViewDiagramFilename = "src/main/asciidoc/images/logical-view.puml";

    @NonNull
    private final String logicalViewCompileFilename = "src/main/asciidoc/images/logical-view.svg";

    @NonNull
    private final String contextViewCompileFilename = "src/main/asciidoc/images/context-view.svg";

    @NonNull
    private final String logicalViewIncludeFilename = "src/main/asciidoc/images/logical-view-include.puml";

    @NonNull
    private final String contextViewIncludeFilename = "src/main/asciidoc/images/context-view-include.puml";

    @NonNull
    private final String vocabularyDocumentFilename = "src/main/asciidoc/include/vocabulary.adoc";

    @NonNull
    private final String componentsDocumentFilename = "src/main/asciidoc/include/components.adoc";

    private final String libraryDiagramFilename = "src/main/asciidoc/images/base-library.puml";

    @Getter
    @Setter
    @Parameter(property = "contextViewDiagramEnabled")
    private boolean contextViewDiagramEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "logicalViewDiagramEnabled")
    private boolean logicalViewDiagramEnabled = true;

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
    @Parameter(property = "componentsEnabled")
    private boolean componentsEnabled = true;

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

        GeneratorLibraryDiagram.create()
                .root(root)
                .enabled(contextViewDiagramEnabled || logicalViewDiagramEnabled)
                .filename(libraryDiagramFilename)
                .execute();

        GeneratorContextViewInclude.create()
                        .root(root)
                        .enabled(contextViewDiagramEnabled)
                        .filename(contextViewIncludeFilename)
                        .execute();

        GeneratorContextViewDiagram.create()
                .root(root)
                .enabled(contextViewDiagramEnabled)
                .filename(contextViewDiagramFilename)
                .execute();

        GeneratorLogicalViewInclude.create()
                .root(root)
                .enabled(logicalViewDiagramEnabled)
                .filename(logicalViewIncludeFilename)
                .execute();

        GeneratorLogicalViewDiagram.create()
                .root(root)
                .enabled(logicalViewDiagramEnabled)
                .filename(logicalViewDiagramFilename)
                .execute();

        GeneratorArchdoc.create()
                .root(root)
                .logicalViewEnabled(logicViewEnabled)
                .componentsEnabled(contextViewEnabled)
                .vocabularyEnabled(vocabularyEnabled)
                .enabled(archdocEnabled)
                .filename(archdocFilename)
                .execute();
    }

    public static void main(String[] args) {
        Generator.create().execute();
    }

}
