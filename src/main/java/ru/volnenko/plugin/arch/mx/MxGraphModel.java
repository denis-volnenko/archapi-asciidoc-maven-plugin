package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class MxGraphModel {

    @JacksonXmlProperty(isAttribute = true, localName = "dx")
    private String dx;

    @JacksonXmlProperty(isAttribute = true, localName = "dy")
    private String dy;

    @JacksonXmlProperty(isAttribute = true, localName = "grid")
    private String grid;

    @JacksonXmlProperty(isAttribute = true, localName = "gridSize")
    private String gridSize;

    @JacksonXmlProperty(isAttribute = true, localName = "guides")
    private String guides;

    @JacksonXmlProperty(isAttribute = true, localName = "tooltips")
    private String tooltips;

    @JacksonXmlProperty(isAttribute = true, localName = "connect")
    private String connect;

    @JacksonXmlProperty(isAttribute = true, localName = "arrows")
    private String arrows;

    @JacksonXmlProperty(isAttribute = true, localName = "fold")
    private String fold;

    @JacksonXmlProperty(isAttribute = true, localName = "page")
    private String page;

    @JacksonXmlProperty(isAttribute = true, localName = "pageScale")
    private String pageScale;

    @JacksonXmlProperty(isAttribute = true, localName = "pageWidth")
    private String pageWidth;

    @JacksonXmlProperty(isAttribute = true, localName = "pageHeight")
    private String pageHeight;

    @JacksonXmlProperty(isAttribute = true, localName = "math")
    private String math;

    @JacksonXmlProperty(isAttribute = true, localName = "shadow")
    private String shadow;

    @JacksonXmlProperty(isAttribute = true, localName = "background")
    private String background;

    @JacksonXmlProperty(isAttribute = true, localName = "backgroundImage")
    private String backgroundImage;

    @JacksonXmlProperty(isAttribute = true, localName = "adaptiveColors")
    private String adaptiveColors;

    @JacksonXmlElementWrapper(useWrapping = false)
    private Root root = new Root();

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }



    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mxGraphModel ");
        MapUtil.apply(stringBuilder, "dx", dx);
        MapUtil.apply(stringBuilder, "dy", dy);
        MapUtil.apply(stringBuilder, "grid", grid);
        MapUtil.apply(stringBuilder, "gridSize", gridSize);
        MapUtil.apply(stringBuilder, "guides", guides);
        MapUtil.apply(stringBuilder, "tooltips", tooltips);
        MapUtil.apply(stringBuilder, "connect", connect);
        MapUtil.apply(stringBuilder, "arrows", arrows);
        MapUtil.apply(stringBuilder, "fold", fold);
        MapUtil.apply(stringBuilder, "page", page);
        MapUtil.apply(stringBuilder, "pageScale", pageScale);
        MapUtil.apply(stringBuilder, "pageWidth", pageWidth);
        MapUtil.apply(stringBuilder, "pageHeight", pageHeight);
        MapUtil.apply(stringBuilder, "math", math);
        MapUtil.apply(stringBuilder, "shadow", shadow);
        MapUtil.apply(stringBuilder, "background", background);
        MapUtil.apply(stringBuilder, "backgroundImage", backgroundImage);
        MapUtil.apply(stringBuilder, "adaptiveColors", adaptiveColors);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append(">").append("\n");
        if (root != null) stringBuilder.append(root);
        stringBuilder.append("</mxGraphModel>").append("\n");
        return stringBuilder.toString();
    }

}
