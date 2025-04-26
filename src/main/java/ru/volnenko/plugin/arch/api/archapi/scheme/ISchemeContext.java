package ru.volnenko.plugin.arch.api.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.archapi.model.IConnection;
import ru.volnenko.plugin.arch.api.archapi.model.IEnvironment;
import ru.volnenko.plugin.arch.api.archapi.model.IService;
import ru.volnenko.plugin.arch.api.archapi.model.IUser;
import ru.volnenko.plugin.arch.api.archapi.model.archapi.ISystem;
import ru.volnenko.plugin.arch.archapi.model.*;
import ru.volnenko.plugin.arch.api.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.api.dataapi.model.IQueue;
import ru.volnenko.plugin.arch.api.dataapi.model.IStorage;
import ru.volnenko.plugin.arch.api.dataapi.model.ITopic;

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
    ISchemeContext append(@NonNull IDataBase dataBase);

    @NonNull
    ISchemeContext append(@NonNull IStorage storage);

    @NonNull
    ISchemeContext append(@NonNull ISystem system);

    @NonNull
    ISchemeContext append(@NonNull IEnvironment environment);

    @NonNull
    ISchemeContext append(@NonNull IConnection connection);

}
