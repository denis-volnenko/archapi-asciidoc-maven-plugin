package ru.volnenko.plugin.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.*;
import ru.volnenko.plugin.archapi.model.archapi.ISystem;
import ru.volnenko.plugin.archapi.model.dataapi.IQueue;
import ru.volnenko.plugin.archapi.model.dataapi.ITopic;

public interface ISchemeContext {

    @NonNull
    ISchemeContext append(@NonNull IService service);

    @NonNull
    ISchemeContext append(@NonNull IUser user);

    @NonNull
    ISchemeContext append(@NonNull ITopic topic);

    @NonNull
    ISchemeContext append(@NonNull IQueue queue);

    @NonNull
    ISchemeContext append(@NonNull ISystem system);

    @NonNull
    ISchemeContext append(@NonNull IEnvironment environment);

    @NonNull
    ISchemeContext append(@NonNull IConnection connection);

}
