package ru.volnenko.plugin.arch.generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import ru.volnenko.plugin.arch.model.impl.*;
import ru.volnenko.plugin.arch.mx.MxFile;
import ru.volnenko.plugin.arch.mxfile.*;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.lang.System;

public final class GeneratorPhysicalDiagram extends AbstractGenerator {

    @NonNull
    public static GeneratorPhysicalDiagram create() {
        return new GeneratorPhysicalDiagram();
    }

    @Override
    public boolean rewrite() {
        return true;
    }

    private XmlMapper xmlMapper = new XmlMapper();

    @NonNull
    @Override
    @SneakyThrows
    public String generate() {
        @NonNull final File file = new File(filename);
        MxFile mxFile = null;
        if (file.exists()) {
            mxFile = xmlMapper.readValue(file, MxFile.class);
        }
        if (mxFile == null) mxFile = mxFile();

//        @NonNull final StringBuilder stringBuilder = new StringBuilder();
//        String key = "view";

//        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>").append("\n");
//        stringBuilder.append("<mxfile host=\"Electron\">").append("\n");
//        stringBuilder.append("<diagram name=\"" + key + "\" id=\"" + key + "\">").append("\n");
//        stringBuilder.append("<mxGraphModel dx=\"707\" dy=\"634\" grid=\"1\" gridSize=\"10\" guides=\"1\" " +
//                "tooltips=\"1\" connect=\"1\" arrows=\"1\" fold=\"1\" page=\"1\" pageScale=\"1\" pageWidth=\"827\" " +
//                "pageHeight=\"1169\" math=\"0\" shadow=\"0\">").append("\n");
//        stringBuilder.append("<root>").append("\n");
//        stringBuilder.append("<mxCell id=\"0\" />").append("\n");
//        stringBuilder.append("<mxCell id=\"1\" parent=\"0\" />").append("\n");

//        if (root() != null) {
//            for (@NonNull final User user : root().users()) {
//                stringBuilder.append(person(user));
//            }
//            for (@NonNull final Service item : root().services()) {
//                stringBuilder.append(service(item));
//            }
//            for (@NonNull final ru.volnenko.plugin.arch.model.impl.Database item : root().databases()) {
//                stringBuilder.append(database(item));
//            }
//            for (@NonNull final ru.volnenko.plugin.arch.model.impl.System item: root().systems()) {
//                stringBuilder.append(system(item));
//            }
//            for (@NonNull final ru.volnenko.plugin.arch.model.impl.Queue item: root().queues()) {
//                stringBuilder.append(queue(item));
//            }
//            for (@NonNull final Environment environment: root().environments()) {
//                stringBuilder.append(boundary(environment));
//            }
//        }
//
//        stringBuilder.append("</root>").append("\n");
//        stringBuilder.append("</mxGraphModel>").append("\n");
//        stringBuilder.append("</diagram>").append("\n");
//        stringBuilder.append("</mxfile>");
//        String value = FileUtil.formatXml(stringBuilder.toString());
        return xmlMapper.writeValueAsString(mxFile);
    }

    @NonNull
    private static String boundary(@NonNull final Environment environment) {
        if (environment.physicalViewEnabled() != null && !environment.physicalViewEnabled()) return "";
        String text = "";
        if (!environment.name().isEmpty()) text = environment.name();
        if (!environment.comment().isEmpty()) text = environment.comment();
        return "<mxCell " +
                "id=\"" + environment.getGroupId() + ":" + environment.getArtifactId() + "\"\n " +
                "parent=\"1\" " +
                "archapi=\"1.0.0\" \n " +
                "groupId=\"" + environment.getGroupId() + "\" " +
                "artifactId=\"" + environment.getArtifactId() + "\" " +
                "type=\"" + environment.getPackaging() + "\" " +
                "version=\"" + environment.getVersion() + "\" " +
                "style=\"rounded=1;whiteSpace=wrap;html=1;fillColor=none;dashed=1;dashPattern=8 8;align=right;verticalAlign=top;perimeterSpacing=1;arcSize=4;\" " +
                "value=\"" + text + "\" " +
                "vertex=\"1\">\n" +
                "<mxGeometry height=\"320\" width=\"400\" x=\"400\" y=\"400\" as=\"geometry\" />\n" +
                "</mxCell>";
    }

    @NonNull
    private static String person(@NonNull final User user) {
        if (user.physicalViewEnabled() != null && !user.physicalViewEnabled()) return "";
        return "<object placeholders=\"1\" " +
                "c4Name=\"" + user.getName() + "\" " +
                "c4Type=\"Person\" " +
                "c4Description=\"" + user.subtitle() + "\" " +
                "archapi=\"1.0.0\" \n " +
                "groupId=\"" + user.getGroupId() + "\" " +
                "artifactId=\"" + user.getArtifactId() + "\" " +
                "type=\"" + user.getPackaging() + "\" " +
                "version=\"" + user.getVersion() + "\" " +
                "label=\"&lt;font style=&quot;font-size: 16px&quot;&gt;&lt;b&gt;%c4Name%&lt;/b&gt;&lt;/font&gt;&lt;div&gt;[%c4Type%]&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;font style=&quot;font-size: 11px&quot;&gt;&lt;font color=&quot;#cccccc&quot;&gt;%c4Description%&lt;/font&gt;&lt;/div&gt;\" " +
                "id=\"" + user.getGroupId() + ":" + user.getArtifactId() + "\">\n " +
                "<mxCell parent=\"1\" style=\"html=1;fontSize=11;dashed=0;whiteSpace=wrap;fillColor=#083F75;strokeColor=#06315C;fontColor=#ffffff;shape=mxgraph.c4.person2;align=center;metaEdit=1;points=[[0.5,0,0],[1,0.5,0],[1,0.75,0],[0.75,1,0],[0.5,1,0],[0.25,1,0],[0,0.75,0],[0,0.5,0]];resizable=0;\" " +
                "vertex=\"1\">\n" +
                "<mxGeometry height=\"180\" width=\"200\" x=\"100\" y=\"880\" as=\"geometry\" />\n" +
                "</mxCell>\n" +
                "</object>";
    }

    @NonNull
    private static String queue(@NonNull final Queue queue) {
        if (queue.physicalViewEnabled() != null && !queue.physicalViewEnabled()) return "";
        return "<object placeholders=\"1\" " +
                "c4Name=\"" + queue.getName() + "\" " +
                "c4Type=\"Container\" " +
                "c4Technology=\"" + queue.title() + "\" " +
                "c4Description=\"" + queue.subtitle() + "\" " +
                "archapi=\"1.0.0\" \n " +
                "groupId=\"" + queue.getGroupId() + "\" " +
                "artifactId=\"" + queue.getArtifactId() + "\" " +
                "type=\"" + queue.getPackaging() + "\" " +
                "version=\"" + queue.getVersion() + "\" " +
                "label=\"&lt;font style=&quot;font-size: 16px&quot;&gt;&lt;b&gt;%c4Name%&lt;/b&gt;&lt;/font&gt;&lt;div&gt;[%c4Type%:&amp;nbsp;%c4Technology%]&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;font style=&quot;font-size: 11px&quot;&gt;&lt;font color=&quot;#E6E6E6&quot;&gt;%c4Description%&lt;/font&gt;&lt;/div&gt;\" " +
                "id=\"" + queue.getGroupId() + ":" + queue.getArtifactId() + "\">\n " +
                "<mxCell parent=\"1\" style=\"shape=cylinder3;size=15;direction=south;whiteSpace=wrap;html=1;boundedLbl=1;rounded=0;labelBackgroundColor=none;fillColor=#23A2D9;fontSize=12;fontColor=#ffffff;align=center;strokeColor=#0E7DAD;metaEdit=1;points=[[0.5,0,0],[1,0.25,0],[1,0.5,0],[1,0.75,0],[0.5,1,0],[0,0.75,0],[0,0.5,0],[0,0.25,0]];resizable=0;\" " +
                "vertex=\"1\">\n" +
                "<mxGeometry height=\"120\" width=\"240\" x=\"80\" y=\"720\" as=\"geometry\" />\n" +
                "</mxCell>\n" +
                "</object>";
    }

    @NonNull
    private static String service(@NonNull final Service service) {
        if (service.physicalViewEnabled() != null && !service.physicalViewEnabled()) return "";
        return "<object placeholders=\"1\" " +
                "c4Name=\"" + service.getName() + "\" " +
                "c4Type=\"Container\" " +
                "c4Technology=\"" + service.title() + "\" " +
                "c4Description=\"" + service.subtitle() + "\" " +
                "archapi=\"1.0.0\" \n " +
                "groupId=\"" + service.getGroupId() + "\" " +
                "artifactId=\"" + service.getArtifactId() + "\" " +
                "type=\"" + service.getPackaging() + "\" " +
                "version=\"" + service.getVersion() + "\" " +
                "label=\"&lt;font style=&quot;font-size: 16px&quot;&gt;&lt;b&gt;%c4Name%&lt;/b&gt;&lt;/font&gt;&lt;div&gt;[%c4Type%: %c4Technology%]&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;font style=&quot;font-size: 11px&quot;&gt;&lt;font color=&quot;#E6E6E6&quot;&gt;%c4Description%&lt;/font&gt;&lt;/div&gt;\" " +
                "id=\"" + service.getGroupId() + ":" + service.getArtifactId() + "\">\n " +
                "<mxCell parent=\"1\" style=\"rounded=1;whiteSpace=wrap;html=1;fontSize=11;labelBackgroundColor=none;fillColor=#23A2D9;fontColor=#ffffff;align=center;arcSize=10;strokeColor=#0E7DAD;metaEdit=1;resizable=0;points=[[0.25,0,0],[0.5,0,0],[0.75,0,0],[1,0.25,0],[1,0.5,0],[1,0.75,0],[0.75,1,0],[0.5,1,0],[0.25,1,0],[0,0.75,0],[0,0.5,0],[0,0.25,0]];\" " +
                "vertex=\"1\">\n" +
                "<mxGeometry height=\"120\" width=\"240\" x=\"80\" y=\"160\" as=\"geometry\" />\n" +
                "</mxCell>\n" +
                "</object>";
    }

    @NonNull
    private static String system(@NonNull final ru.volnenko.plugin.arch.model.impl.System system) {
        if (system.physicalViewEnabled() != null && !system.physicalViewEnabled()) return "";
        return "<object placeholders=\"1\" " +
                "c4Name=\"" + system.getName() + "\" " +
                "c4Type=\"Software System\" " +
                "c4Description=\"" + system.subtitle() + "\" " +
                "archapi=\"1.0.0\" \n " +
                "groupId=\"" + system.getGroupId() + "\" " +
                "artifactId=\"" + system.getArtifactId() + "\" " +
                "type=\"" + system.getPackaging() + "\" " +
                "version=\"" + system.getVersion() + "\" " +
                "label=\"&lt;font style=&quot;font-size: 16px&quot;&gt;&lt;b&gt;%c4Name%&lt;/b&gt;&lt;/font&gt;&lt;div&gt;[%c4Type%]&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;font style=&quot;font-size: 11px&quot;&gt;&lt;font color=&quot;#cccccc&quot;&gt;%c4Description%&lt;/font&gt;&lt;/div&gt;\" " +
                "id=\"" + system.getGroupId() + ":" + system.getArtifactId() + "\">\n " +
                "<mxCell parent=\"1\" style=\"rounded=1;whiteSpace=wrap;html=1;labelBackgroundColor=none;fillColor=#1061B0;fontColor=#ffffff;align=center;arcSize=10;strokeColor=#0D5091;metaEdit=1;resizable=0;points=[[0.25,0,0],[0.5,0,0],[0.75,0,0],[1,0.25,0],[1,0.5,0],[1,0.75,0],[0.75,1,0],[0.5,1,0],[0.25,1,0],[0,0.75,0],[0,0.5,0],[0,0.25,0]];\" " +
                "vertex=\"1\">\n" +
                "<mxGeometry height=\"120\" width=\"240\" x=\"80\" y=\"360\" as=\"geometry\" />\n" +
                "</mxCell>\n" +
                "</object>";
    }

    @NonNull
    private static String database(@NonNull final Database database) {
        if (database.physicalViewEnabled() != null && !database.physicalViewEnabled()) return "";
        return "<object placeholders=\"1\" " +
                "c4Name=\"" + database.getName() + "\" " +
                "c4Type=\"Container\" " +
                "c4Technology=\"" + database.title() + "\" " +
                "c4Description=\"" + database.subtitle() + "\" " +
                "archapi=\"1.0.0\" \n " +
                "groupId=\"" + database.getGroupId() + "\" " +
                "artifactId=\"" + database.getArtifactId() + "\" " +
                "type=\"" + database.getPackaging() + "\" " +
                "version=\"" + database.getVersion() + "\" " +
                "label=\"&lt;font style=&quot;font-size: 16px&quot;&gt;&lt;b&gt;%c4Name%&lt;/b&gt;&lt;/font&gt;&lt;div&gt;[%c4Type%:&amp;nbsp;%c4Technology%]&lt;/div&gt;&lt;br&gt;&lt;div&gt;&lt;font style=&quot;font-size: 11px&quot;&gt;&lt;font color=&quot;#E6E6E6&quot;&gt;%c4Description%&lt;/font&gt;&lt;/div&gt;\" " +
                "id=\"" + database.getGroupId() + ":" + database.getArtifactId() + "\">\n " +
                "<mxCell parent=\"1\" style=\"shape=cylinder3;size=15;whiteSpace=wrap;html=1;boundedLbl=1;rounded=0;labelBackgroundColor=none;fillColor=#23A2D9;fontSize=12;fontColor=#ffffff;align=center;strokeColor=#0E7DAD;metaEdit=1;points=[[0.5,0,0],[1,0.25,0],[1,0.5,0],[1,0.75,0],[0.5,1,0],[0,0.75,0],[0,0.5,0],[0,0.25,0]];resizable=0;\" " +
                "vertex=\"1\">\n" +
                "<mxGeometry height=\"120\" width=\"240\" x=\"80\" y=\"560\" as=\"geometry\" />\n" +
                "</mxCell>\n" +
                "</object>";
    }

    @SneakyThrows
    public static void main(String[] args) throws JAXBException {
//        final String xml = FileUtils.fileRead(new File("physical-view.drawio"));
        final XmlMapper mapper = new XmlMapper();
//        final File file = new File("physical-view.drawio");
//        MxFile root = mapper.readValue(file, MxFile.class);
//        System.out.println(root);
        MxFile mxFile = mxFile();
        mapper.writeValue(new File("test.drawio"), mxFile);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mxFile));
    }

    @NonNull
    private static MxFile mxFile() {
        MxFile mxFile = new MxFile();
        mxFile.setHost("Electron");
        return mxFile;
    }

}
