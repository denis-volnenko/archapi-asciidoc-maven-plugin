package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class MxPoint {

    @JacksonXmlProperty(isAttribute = true, localName = "x")
    protected String x;

    @JacksonXmlProperty(isAttribute = true, localName = "y")
    protected String y;

    @JsonIgnore
    private Map<String, String> properties = new LinkedHashMap<>();

    @JsonAnySetter
    public void properties(String key, String value) {
        this.properties.put(key, value);
    }

    @Override
    public String toString() {
        @NonNull final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mxPoint ");
        MapUtil.apply(stringBuilder, "x", x);
        MapUtil.apply(stringBuilder, "y", y);
        MapUtil.apply(stringBuilder, properties);
        stringBuilder.append("/>").append("\n");
        return stringBuilder.toString();
    }

}
