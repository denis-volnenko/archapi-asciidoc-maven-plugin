package ru.volnenko.plugin.archapi.scheme.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.*;
import ru.volnenko.plugin.archapi.model.archapi.ISystem;
import ru.volnenko.plugin.archapi.model.dataapi.IQueue;
import ru.volnenko.plugin.archapi.model.dataapi.IStorage;
import ru.volnenko.plugin.archapi.model.dataapi.ITopic;
import ru.volnenko.plugin.archapi.scheme.ISchemeContext;
import ru.volnenko.plugin.archapi.scheme.ISchemeInfrastructure;

public final class SchemeInfrastructure implements ISchemeInfrastructure {

    @Override
    public @NonNull ISchemeContext append(@NonNull IService service) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IUser user) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull ITopic topic) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IQueue queue) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IDataBase dataBase) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IStorage storage) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull ISystem system) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IEnvironment environment) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IConnection connection) {
        return null;
    }
}
