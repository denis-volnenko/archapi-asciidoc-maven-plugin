package ru.volnenko.plugin.archapi.basic.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.model.archapi.IBalancer;

public interface ISchemeInfrastructure extends ISchemeComponent {

    @NonNull
    ISchemeComponent append(@NonNull IBalancer balancer);

}
