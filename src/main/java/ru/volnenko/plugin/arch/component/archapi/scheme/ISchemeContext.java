package ru.volnenko.plugin.arch.component.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.model.IConnection;
import ru.volnenko.plugin.arch.component.archapi.model.IEnvironment;
import ru.volnenko.plugin.arch.component.archapi.model.IService;
import ru.volnenko.plugin.arch.component.archapi.model.IUser;
import ru.volnenko.plugin.arch.component.archapi.model.archapi.ISystem;
import ru.volnenko.plugin.arch.archapi.model.*;
import ru.volnenko.plugin.arch.component.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.component.dataapi.model.IQueue;
import ru.volnenko.plugin.arch.component.dataapi.model.IStorage;
import ru.volnenko.plugin.arch.component.dataapi.model.ITopic;

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
