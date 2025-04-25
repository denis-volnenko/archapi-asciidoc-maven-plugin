package ru.volnenko.plugin.archapi.dataapi.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.basic.model.archapi.impl.AbstractModel;
import ru.volnenko.plugin.archapi.model.impl.AbstractBasicEntity;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Queue extends AbstractBasicEntity {

}
