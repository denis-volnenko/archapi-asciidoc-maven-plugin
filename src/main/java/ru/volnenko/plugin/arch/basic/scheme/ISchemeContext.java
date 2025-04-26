package ru.volnenko.plugin.arch.basic.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.model.*;
import ru.volnenko.plugin.arch.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.basic.model.archapi.ISystem;
import ru.volnenko.plugin.arch.dataapi.model.IQueue;
import ru.volnenko.plugin.arch.dataapi.model.IStorage;
import ru.volnenko.plugin.arch.dataapi.model.ITopic;

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
