package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.util.MapUtil;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxCell {

    @JacksonXmlProperty(isAttribute = true, localName = "groupId")
    private String groupId;

    @JacksonXmlProperty(isAttribute = true, localName = "archapi")
    private String archapi;

    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;

    @JacksonXmlProperty(isAttribute = true, localName = "artifactId")
    private String artifactId;

    @JacksonXmlProperty(isAttribute = true, localName = "version")
    private String version;

    @JacksonXmlProperty(isAttribute = true, localName = "packaging")
    private String packaging;

    @JacksonXmlProperty(isAttribute = true, localName = "parent")
    private String parent;

    @JacksonXmlProperty(isAttribute = true, localName = "value")
    private String value;

    @JacksonXmlProperty(isAttribute = true, localName = "style")
    private String style;

    @JacksonXmlProperty(isAttribute = true, localName = "vertex")
    private String vertex;

    @JacksonXmlProperty(isAttribute = true, localName = "edge")
    private String edge;

    @JacksonXmlProperty(isAttribute = true, localName = "connectable")
    private String connectable;

    @JacksonXmlProperty(isAttribute = true, localName = "source")
    private String source;

    @JacksonXmlProperty(isAttribute = true, localName = "target")
    private String target;

    @JacksonXmlProperty(isAttribute = true, localName = "collapsed")
    private String collapsed;

    @JacksonXmlProperty(isAttribute = true, localName = "visible")
    private String visible;

    @JacksonXmlElementWrapper(useWrapping = false)
    private MxGeometry mxGeometry;

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mxCell ");

        MapUtil.apply(stringBuilder, "archapi", archapi);
        MapUtil.apply(stringBuilder, "groupId", groupId);
        MapUtil.apply(stringBuilder, "artifactId", artifactId);
        MapUtil.apply(stringBuilder, "version", version);
        MapUtil.apply(stringBuilder, "packaging", packaging);

        MapUtil.apply(stringBuilder, "id", id);
        MapUtil.apply(stringBuilder, "parent", parent);
        MapUtil.apply(stringBuilder, "value", value);
        MapUtil.apply(stringBuilder, "style", style);
        MapUtil.apply(stringBuilder, "vertex", vertex);
        MapUtil.apply(stringBuilder, "edge", edge);
        MapUtil.apply(stringBuilder, "connectable", connectable);
        MapUtil.apply(stringBuilder, "source", source);
        MapUtil.apply(stringBuilder, "target", target);
        MapUtil.apply(stringBuilder, "collapsed", collapsed);
        MapUtil.apply(stringBuilder, "visible", visible);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append(">").append("\n");
        if (mxGeometry != null) stringBuilder.append(mxGeometry);
        stringBuilder.append("</mxCell>").append("\n");
        return stringBuilder.toString();
    }

}
