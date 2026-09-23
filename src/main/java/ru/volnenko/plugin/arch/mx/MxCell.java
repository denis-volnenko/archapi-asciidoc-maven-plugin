package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxCell {

    private String id;

    private String parent;

    private String value;

    private String style;

    private String vertex;

    private String edge;

    private String connectable;

    private String source;

    private String target;

    private String collapsed;

    private String visible;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxGeometry> mxGeometry;

}
