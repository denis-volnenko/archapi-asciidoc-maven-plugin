package ru.volnenko.plugin.arch.util;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Map;

public class MapUtil {

    public static void apply(StringBuilder stringBuilder, String field, String value) {
//        if (value != null) stringBuilder.append(field).append("=").append("\"").append(value).append("\" ");
        if (value != null) stringBuilder.append(field).append("=").append("\"").append(StringEscapeUtils.escapeXml11(value)).append("\" ");
    }

    public static void apply(StringBuilder stringBuilder, Map<String, String> properties) {
        if (properties != null) {
            for (final Map.Entry<String, String> entry: properties.entrySet()) {
                final String key = entry.getKey();
                final String value = entry.getValue();
                if (key == null || key.isEmpty()) continue;
                if (value == null || value.isEmpty()) continue;
                stringBuilder.append(" ").append(key).append("=").append("\"").append(value).append("\"");
            }
        }
    }

}
