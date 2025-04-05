package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.volnenko.plugin.archapi.model.IBucket;

@Getter
@Setter
@NoArgsConstructor
public final class Bucket extends AbstractModel implements IBucket {

    private String name;

    private String description;

}
