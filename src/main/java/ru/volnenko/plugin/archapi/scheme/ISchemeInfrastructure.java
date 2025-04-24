package ru.volnenko.plugin.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.archapi.IBalancer;

public interface ISchemeInfrastructure extends ISchemeComponent {

    @NonNull
    ISchemeComponent append(@NonNull IBalancer balancer);

}
