package ru.volnenko.plugin.arch.component.techapi.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.impl.AbstractVersionEntity;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Framework extends AbstractVersionEntity {

}
