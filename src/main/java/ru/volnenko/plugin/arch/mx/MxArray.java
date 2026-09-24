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
public class MxArray {

    @JacksonXmlProperty(isAttribute = true, localName = "as")
    private String as;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxPoint> mxPoint;

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }

    @JsonSetter(value =  "mxPoint")
    public void setMxPointXml(MxPoint object) {
        if (this.mxPoint == null) {
            this.mxPoint = new ArrayList<>();
        }
        this.mxPoint.add(object);
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<Array ");
        MapUtil.apply(stringBuilder, "as", as);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append(">").append("\n");
        if (mxPoint != null) for (MxPoint p: mxPoint) stringBuilder.append(p);
        stringBuilder.append("</Array>").append("\n");
        return stringBuilder.toString();
    }

}
