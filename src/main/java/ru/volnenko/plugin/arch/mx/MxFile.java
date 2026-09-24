package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.impl.MavenProjectDto;
import ru.volnenko.plugin.arch.util.FileUtil;
import ru.volnenko.plugin.arch.util.MapUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonRootName("mxfile")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxFile {

    @JacksonXmlProperty(isAttribute = true, localName = "host")
    private String host;

    @JacksonXmlProperty(isAttribute = true, localName = "modified")
    private String modified;

    @JacksonXmlProperty(isAttribute = true, localName = "agent")
    private String agent;

    @JacksonXmlProperty(isAttribute = true, localName = "etag")
    private String etag;

    @JacksonXmlProperty(isAttribute = true, localName = "type")
    private String type;

    @JacksonXmlProperty(isAttribute = true, localName = "version")
    private String version;

    @JacksonXmlProperty(isAttribute = true, localName = "compressed")
    private String compressed;

    @JacksonXmlProperty(isAttribute = true, localName = "pages")
    private String pages;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Diagram> diagram = new ArrayList<>();

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }

    @NonNull
    public MxCell merge(@NonNull MavenProjectDto dto, @NonNull File path) {
        return root().mergeMxCell(dto, path);
    }

    public Root root() {
        if (diagram == null || diagram.isEmpty()) return null;
        final Diagram d = diagram.get(0);
        final MxGraphModel m = d.getMxGraphModel();
        if (m == null) return null;
        return m.getRoot();
    }

    public MxFile diagram(Diagram diagram) {
        this.diagram.add(diagram);
        return this;
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mxfile ");
        MapUtil.apply(stringBuilder, "host", host);
        MapUtil.apply(stringBuilder, "modified", modified);
        MapUtil.apply(stringBuilder, "agent", agent);
        MapUtil.apply(stringBuilder, "etag", etag);
        MapUtil.apply(stringBuilder, "type", type);
        MapUtil.apply(stringBuilder, "version", version);
        MapUtil.apply(stringBuilder, "compressed", compressed);
        MapUtil.apply(stringBuilder, "pages", pages);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append(">").append("\n");
        if (diagram != null) for (Diagram d: diagram) stringBuilder.append(d);
        stringBuilder.append("</mxfile>").append("\n");
        return stringBuilder.toString();
    }

}
