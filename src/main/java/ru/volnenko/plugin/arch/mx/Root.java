package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxCell> mxCell;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<UserObject> UserObject;

}
