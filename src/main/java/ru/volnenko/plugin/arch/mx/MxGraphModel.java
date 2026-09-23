package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxGraphModel {

    private String dx;

    private String dy;

    private String grid;

    private String gridSize;

    private String guides;

    private String tooltips;

    private String connect;

    private String arrows;

    private String fold;

    private String page;

    private String pageScale;

    private String pageWidth;

    private String pageHeight;

    private String math;

    private String shadow;

    private String background;

    private String backgroundImage;

    private String adaptiveColors;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Root> root;

}
