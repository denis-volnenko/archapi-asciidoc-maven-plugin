package ru.volnenko.plugin.arch.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.NonNull;

public final class MapperUtil {

    @NonNull
    private static final ObjectMapper JSON = new ObjectMapper();

    @NonNull
    private static final ObjectMapper YAML = new YAMLMapper();

    static {
        JSON.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        YAML.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        JSON.registerModule(new JSONPModule());
//        YAML.registerModule(new JSONPModule());
//        JSON.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
//        YAML.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    @NonNull
    public static ObjectMapper json() {
        return JSON;
    }

    @NonNull
    public static ObjectMapper yaml() {
        return YAML;
    }

}
