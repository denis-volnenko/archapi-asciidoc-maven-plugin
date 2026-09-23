package ru.volnenko.plugin.arch.mx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import ru.volnenko.plugin.arch.mxfile.MxPointAsType;

import javax.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MxPoint {

    protected Double x;

    protected Double y;


}
