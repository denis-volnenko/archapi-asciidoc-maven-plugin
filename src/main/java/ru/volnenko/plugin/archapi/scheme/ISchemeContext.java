package ru.volnenko.plugin.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.*;

public interface ISchemeContext {

    @NonNull
    ISchemeContext append(@NonNull IService service);

    @NonNull
    ISchemeContext append(@NonNull IServer server);

    @NonNull
    ISchemeContext append(@NonNull IUser user);

    @NonNull
    ISchemeContext append(@NonNull IEnvironment environment);

    @NonNull
    ISchemeContext append(@NonNull IConnection connection);

}
