package ru.volnenko.plugin.arch.generator;

import lombok.NonNull;
import lombok.SneakyThrows;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceFileReader;
import org.codehaus.plexus.util.FileUtils;
import ru.volnenko.plugin.arch.model.ICoordinate;
import ru.volnenko.plugin.arch.model.impl.*;
import ru.volnenko.plugin.arch.util.StringUtil;

import java.io.File;
import java.io.InputStream;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractGenerator {

    private boolean enabled = false;

    @NonNull
    protected String filename = "file.adoc";

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

    @NonNull
    protected List<Environment> boundaries(@NonNull List<MavenDependencyDto> dependencies) {
        @NonNull final List<Environment> result = new ArrayList<>();

        final Components components = root().getComponents();
        if (components == null) return result;

        final Map<String, Environment> environments = components.getEnvironments();
        if (environments == null) return result;

        for (final MavenDependencyDto dependency: dependencies) {
            if (dependency == null) continue;
            if ("Environment".equals(dependency.getType())) {
                final Environment environment = environments.get(dependency.getGroupId() + ":" + dependency.getArtifactId());
                if (environment == null) continue;
                result.add(environment);
            }
        }

        return result;
    }

    protected void renderUser(
            @NonNull final StringBuilder stringBuilder,
            @NonNull final User user,
            @NonNull final Map<ICoordinate, MavenProjectDto> variables,
            final Boolean viewEnabled,
            String filename
    ) {
        if (viewEnabled != null && !viewEnabled) return;

        @NonNull final List<Environment> environments = boundaries(user.dependencies());
        startBoundary(stringBuilder, environments);
        for (int i = 0; i < environments.size(); i++) stringBuilder.append("\t");
        String component = "Person";
        String scope = root().scope(user);
        if (scope == null) scope = "compile";
        String tags = "";
        if ("provided".equals(scope)) component += "_Ext";
        if ("compile".equals(scope)) tags = "selected";
        String plantuml = renderUser(component, user.url(), user.name(), user.title(), user.subtitle(), tags);
        stringBuilder.append(plantuml);
        endBoundary(stringBuilder, environments);
        stringBuilder.append("\n");
        variables.put(new MavenCoordinateDto(user), user);
        if (filename != null) drawSvg(user, plantuml, filename);
    }

    @NonNull
    protected String renderUser(
            @NonNull final String component,
            @NonNull final String constant,
            @NonNull final String name,
            @NonNull final String title,
            @NonNull final String subtitle,
            @NonNull final String tags
    ) {
        if (constant.isEmpty()) return "";
        if (name.isEmpty()) return "";
        String plantuml = new StringBuilder()
                .append(component).append("(")
                .append(constant).append(", ")
                .append("\"").append(name).append("\"").append(", ")
                .append("\"").append(title).append("\"").append(", ")
                .append("\"").append(subtitle).append("\"").append(", ")
                .append("$tags = \"").append(tags).append("\"")
                .append(")").append("\n").toString();

        return plantuml;
    }

    @NonNull
    protected String renderComponent(
            @NonNull final String component,
            @NonNull final String constant,
            @NonNull final String name,
            @NonNull final String title,
            @NonNull final String subtitle,
            @NonNull final String tags
    ) {
        if (component.isEmpty()) return "";
        if (constant.isEmpty()) return "";
        if (name.isEmpty()) return "";
        return new StringBuilder()
                .append(component)
                .append("(").append(constant).append(", ")
                .append("\"").append(name).append("\"").append(", ")
                .append("\"").append(title).append("\"").append(", ")
                .append("\"").append(subtitle).append("\"").append(", ")
                .append("$tags = \"").append(tags).append("\"")
                .append(")").append("\n").toString();
    }

    protected void startBoundary(@NonNull final StringBuilder stringBuilder, @NonNull final List<Environment> environments) {
        int index = 0;
        for (final Environment environment : environments) {
            if (environment == null) continue;
            for (int i = 0; i < index; i++) stringBuilder.append("\t");
            stringBuilder.append("Boundary(" + environment.url() + ", \"" + environment.name() + "\"" + ") { ").append("\n");
            index++;
        }
    }

    protected void endBoundary(@NonNull final StringBuilder stringBuilder, @NonNull final List<Environment> environments) {
        int index = environments.size() -1;
        for (Environment environment : environments) {
            for (int i = index; i > 0 ; i--) stringBuilder.append("\t");
            stringBuilder.append("}").append("\n");
            index--;
        }
    }

    @SneakyThrows
    protected void drawSvg(MavenProjectDto mavenProjectDto, String plantuml, String filename) {
        @NonNull final String path = new File(filename).getParent();
        File folder = new File(path + "/logical-view");
        if (mavenProjectDto.getUrl() != null && !mavenProjectDto.getUrl().isEmpty()) {
            final File file = new File(folder.getPath() + "/" + mavenProjectDto.getUrl() + ".puml");
            System.out.println("FILE:" + file.getAbsoluteFile());
            if (!file.exists()) file.createNewFile();

            final StringBuilder sb = new StringBuilder();
            sb.append("@startuml").append("\n");
            sb.append("!include ../base-library.puml").append("\n");
            sb.append("HIDE_STEREOTYPE()").append("\n");
            sb.append(plantuml);
            sb.append("@enduml").append("\n");
            FileUtils.fileWrite(file, sb.toString());

            @NonNull final FileFormatOption option = new FileFormatOption(FileFormat.SVG);
            @NonNull final SourceFileReader reader = new SourceFileReader(file, new File("."), option);
            reader.getGeneratedImages();
        }
    }

}
