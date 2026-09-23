package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserObject {

    private String id;

    private String label;

    private String link;

    private String tags;

    private String tooltip;

    private String placeholders;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxCell> mxCell;

}
