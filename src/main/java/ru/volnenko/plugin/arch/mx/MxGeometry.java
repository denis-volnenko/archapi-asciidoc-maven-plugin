package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.volnenko.plugin.arch.util.MapUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxGeometry {

    @JacksonXmlProperty(isAttribute = true, localName = "x")
    private String x;

    @JacksonXmlProperty(isAttribute = true, localName = "y")
    private String y;

    @JacksonXmlProperty(isAttribute = true, localName = "width")
    private String width;

    @JacksonXmlProperty(isAttribute = true, localName = "height")
    private String height;

    @JacksonXmlProperty(isAttribute = true, localName = "relative")
    private String relative;

    @JacksonXmlProperty(isAttribute = true, localName = "as")
    private String as;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxPoint> mxPoint;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxRectangle> mxRectangle;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxArray> array;

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonSetter(value =  "Array")
    public void setArrayXml(MxArray object) {
        if (this.array == null) {
            this.array = new ArrayList<>();
        }
        this.array.add(object);
    }

    @JsonSetter(value =  "mxPoint")
    public void setMxPointXml(MxPoint object) {
        if (this.mxPoint == null) {
            this.mxPoint = new ArrayList<>();
        }
        this.mxPoint.add(object);
    }

    @JsonSetter(value =  "mxRectangle")
    public void setMxRectangleXml(MxRectangle object) {
        if (this.mxRectangle == null) {
            this.mxRectangle = new ArrayList<>();
        }
        this.mxRectangle.add(object);
    }

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mxGeometry ");
        MapUtil.apply(stringBuilder, "x", x);
        MapUtil.apply(stringBuilder, "y", y);
        MapUtil.apply(stringBuilder, "width", width);
        MapUtil.apply(stringBuilder, "height", height);
        MapUtil.apply(stringBuilder, "relative", relative);
        MapUtil.apply(stringBuilder, "as", as);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append(">").append("\n");
        if (mxPoint != null) for (MxPoint p: mxPoint) stringBuilder.append(p);
        if (mxRectangle != null) for (MxRectangle p: mxRectangle) stringBuilder.append(p);
        if (array != null) for (MxArray p: array) stringBuilder.append(p);
        stringBuilder.append("</mxGeometry>").append("\n");
        return stringBuilder.toString();
    }

}
