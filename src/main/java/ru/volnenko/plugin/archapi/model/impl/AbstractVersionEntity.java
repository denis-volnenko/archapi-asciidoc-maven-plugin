package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IBasicVersion;

@Getter
@Setter
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
