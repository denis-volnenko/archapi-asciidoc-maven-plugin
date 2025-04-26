package ru.volnenko.plugin.arch.model.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.arch.model.IBasicVersion;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractVersionEntity extends AbstractBasicEntity implements IBasicVersion {

    private String version;

    @Override
    public String version() {
        return version;
    }

    @Override
    public void version(String version) {
        this.version = version;
    }

}
