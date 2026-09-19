package ru.volnenko.plugin.arch.util;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public final class FileUtil {

    @SneakyThrows
    public static void reformat(@NonNull final File file) {
        @NonNull final MavenXpp3Reader reader = new MavenXpp3Reader();
        @NonNull final Model model = reader.read(new FileReader(file));
        model.getDependencies().sort(new Comparator<Dependency>() {
            @Override
            public int compare(Dependency dependency, Dependency t1) {
                return dependency.getType().compareTo(t1.getType());
            }
        });
        @NonNull final MavenXpp3Writer writer = new MavenXpp3Writer();
        try (FileWriter fileWriter = new FileWriter(file)) {
            writer.write(fileWriter, model);
        }
        FileUtil.formatXml(file);
    }

    @SneakyThrows
    public static void formatXml(@NonNull final File file) {
        final String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        final String xml = (prettyPrintByDom4j(content, 4, false));
        Files.write(Paths.get(file.toURI()), xml.getBytes(StandardCharsets.UTF_8));
    }

    @NonNull
    public static String formatXml(@NonNull final String content) {
        return prettyPrintByDom4j(content, 4, false);
    }

    public static String prettyPrintByDom4j(String xmlString, int indent, boolean skipDeclaration) {
        try {
            @NonNull final OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndentSize(indent);
            format.setNewLineAfterDeclaration(false);
            format.setSuppressDeclaration(skipDeclaration);
            format.setEncoding("UTF-8");

            org.dom4j.Document document = DocumentHelper.parseText(xmlString);
            final Element properties = document.getRootElement().element("properties");
            if (properties != null) {
                @NonNull final List<Element> elements = properties.elements();
                elements.sort(new Comparator<Element>() {
                    @Override
                    public int compare(@NonNull Element t1, @NonNull Element t2) {
                        return t1.getName().compareTo(t2.getName());
                    }
                });

                properties.clearContent();
                for (@NonNull final Element element : elements) {
                    properties.add(element);
                }
            }
            StringWriter sw = new StringWriter();
            XMLWriter writer = new XMLWriter(sw, format);
            writer.write(document);
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error occurs when pretty-printing xml:\n" + xmlString, e);
        }
    }

}
