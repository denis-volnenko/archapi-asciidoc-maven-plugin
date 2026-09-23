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
public class MxGeometry {

    @JacksonXmlProperty(isAttribute = true, localName = "x")
    private Double x;

    @JacksonXmlProperty(isAttribute = true, localName = "y")
    private Double y;

    @JacksonXmlProperty(isAttribute = true, localName = "width")
    private Double width;

    @JacksonXmlProperty(isAttribute = true, localName = "height")
    private Double height;

    @JacksonXmlProperty(isAttribute = true, localName = "relative")
    private String relative;

    @JacksonXmlProperty(isAttribute = true, localName = "as")
    private String as;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxPoint> mxPoint;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<MxRectangle> mxRectangle;

}
