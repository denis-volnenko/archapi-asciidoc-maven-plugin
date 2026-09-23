package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<Diagram> diagram;

}
