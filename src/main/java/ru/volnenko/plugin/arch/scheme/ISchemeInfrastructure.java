package ru.volnenko.plugin.arch.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.model.archapi.IBalancer;

public interface ISchemeInfrastructure extends ISchemeComponent {

    @NonNull
    ISchemeComponent append(@NonNull IBalancer balancer);

}
