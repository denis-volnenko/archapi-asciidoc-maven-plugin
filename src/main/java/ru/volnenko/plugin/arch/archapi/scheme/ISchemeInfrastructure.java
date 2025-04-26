package ru.volnenko.plugin.arch.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.archapi.model.archapi.IBalancer;

public interface ISchemeInfrastructure extends ISchemeComponent {

    @NonNull
    ISchemeComponent append(@NonNull IBalancer balancer);

}
