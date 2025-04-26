package ru.volnenko.plugin.archapi.techapi.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.impl.AbstractBasicEntity;
import ru.volnenko.plugin.archapi.model.impl.AbstractVersionEntity;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Platform extends AbstractVersionEntity {

}
