package ru.volnenko.plugin.arch;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;
import ru.volnenko.plugin.arch.builder.MavenProjectBuilder;
import ru.volnenko.plugin.arch.generator.*;
import ru.volnenko.plugin.arch.model.impl.Root;
import ru.volnenko.plugin.arch.util.MapperUtil;

import java.io.File;
import java.io.FileReader;

public abstract class AbstractGenerator  extends AbstractMojo {

    @Getter
    @Setter
    @Parameter(property = "serviceName")
    protected String serviceName = "Сервис";

    @Getter
    @Setter
    @Parameter(property = "headerFirstEnabled")
    protected boolean headerFirstEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "headerSecondEnabled")
    protected boolean headerSecondEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "tableOfContentsEnabled")
    protected boolean tableOfContentsEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "archdocEnabled")
    protected boolean archdocEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "contextViewEnabled")
    protected boolean contextViewEnabled = true;

    @NonNull
    protected final String archdocFilename = "src/main/asciidoc/archdoc.adoc";

    @NonNull
    protected final String contextViewDiagramFilename = "src/main/asciidoc/images/context-view.puml";

    @NonNull
    protected final String logicalViewDiagramFilename = "src/main/asciidoc/images/logical-view.puml";

    @NonNull
    protected final String logicalViewCompileFilename = "src/main/asciidoc/images/logical-view.svg";

    @NonNull
    protected final String contextViewCompileFilename = "src/main/asciidoc/images/context-view.svg";

    @NonNull
    protected final String logicalViewIncludeFilename = "src/main/asciidoc/images/logical-view-include.puml";

    @NonNull
    protected final String contextViewIncludeFilename = "src/main/asciidoc/images/context-view-include.puml";

    @NonNull
    protected final String vocabularyDocumentFilename = "src/main/asciidoc/include/vocabulary.adoc";

    @NonNull
    protected final String componentsDocumentFilename = "src/main/asciidoc/include/components.adoc";

    @NonNull
    protected final String libraryDiagramFilename = "src/main/asciidoc/images/base-library.puml";

    @Getter
    @Setter
    @Parameter(property = "contextViewDiagramEnabled")
    protected boolean contextViewDiagramEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "logicalViewDiagramEnabled")
    protected boolean logicalViewDiagramEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "logicViewEnabled")
    protected boolean logicViewEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "vocabularyEnabled")
    protected boolean vocabularyEnabled = true;

    @Getter
    @Setter
    @Parameter(property = "componentsEnabled")
    protected boolean componentsEnabled = true;

    @Parameter(defaultValue = "${project}", required = true)
    protected MavenProject project;

    @Parameter(defaultValue = "${settings}", required = true)
    protected Settings settings;

    @NonNull
    @SneakyThrows
    private Model model() {
        final File pomFile = new File("pom.xml"); // Path to target pom.xml
        final MavenXpp3Reader reader = new MavenXpp3Reader();
        final Model model = reader.read(new FileReader(pomFile));
        return model;
    }

    @SneakyThrows
    public void generate() {
        @NonNull final MavenProjectBuilder mavenProjectBuilder = new MavenProjectBuilder(settings);
        @NonNull final String yaml = mavenProjectBuilder.yaml(model());
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

        GeneratorContextViewCompile.create()
                .enabled(logicalViewDiagramEnabled)
                .source(contextViewDiagramFilename)
                .target(contextViewCompileFilename)
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

        GeneratorLogicalViewCompile.create()
                .enabled(logicalViewDiagramEnabled)
                .source(logicalViewDiagramFilename)
                .target(logicalViewCompileFilename)
                .execute();

        GeneratorArchdoc.create()
                .root(root)
                .contextViewEnabled(contextViewEnabled)
                .logicalViewEnabled(logicViewEnabled)
                .componentsEnabled(contextViewEnabled)
                .vocabularyEnabled(vocabularyEnabled)
                .enabled(archdocEnabled)
                .filename(archdocFilename)
                .execute();
    }

}
