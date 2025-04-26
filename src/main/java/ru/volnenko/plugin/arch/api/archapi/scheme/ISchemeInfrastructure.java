package ru.volnenko.plugin.arch.api.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.archapi.model.archapi.IBalancer;

public interface ISchemeInfrastructure extends ISchemeComponent {

    @NonNull
    ISchemeComponent append(@NonNull IBalancer balancer);

}
