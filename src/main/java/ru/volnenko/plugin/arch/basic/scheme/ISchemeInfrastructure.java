package ru.volnenko.plugin.arch.basic.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.model.archapi.IBalancer;

public interface ISchemeInfrastructure extends ISchemeComponent {

    @NonNull
    ISchemeComponent append(@NonNull IBalancer balancer);

}
