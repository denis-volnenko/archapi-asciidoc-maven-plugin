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
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomObject {

    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private String id;

    @JacksonXmlProperty(isAttribute = true, localName = "label")
    private String label;

    @JacksonXmlProperty(isAttribute = true, localName = "link")
    private String link;

    @JacksonXmlProperty(isAttribute = true, localName = "tags")
    private String tags;

    @JacksonXmlProperty(isAttribute = true, localName = "tooltip")
    private String tooltip;

    @JacksonXmlProperty(isAttribute = true, localName = "placeholders")
    private String placeholders;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxCell> mxCell;

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<object ");
        MapUtil.apply(stringBuilder, "id", id);
        MapUtil.apply(stringBuilder, "label", label);
        MapUtil.apply(stringBuilder, "link", link);
        MapUtil.apply(stringBuilder, "tags", tags);
        MapUtil.apply(stringBuilder, "tooltip", tooltip);
        MapUtil.apply(stringBuilder, "placeholders", placeholders);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append(">").append("\n");
        if (mxCell != null) for (MxCell c: mxCell) stringBuilder.append(c);
        stringBuilder.append("</object>").append("\n");
        return stringBuilder.toString();
    }

}
