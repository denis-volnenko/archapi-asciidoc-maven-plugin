package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxFile {

    private String host;

    private String modified;

    private String agent;

    private String etag;

    private String type;

    private String version;

    private String compressed;

    private String pages;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Diagram> diagram;

}
