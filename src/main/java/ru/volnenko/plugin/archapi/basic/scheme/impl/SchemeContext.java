package ru.volnenko.plugin.archapi.basic.scheme.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.model.*;
import ru.volnenko.plugin.archapi.basic.scheme.ISchemeContext;
import ru.volnenko.plugin.archapi.model.*;
import ru.volnenko.plugin.archapi.basic.model.archapi.ISystem;
import ru.volnenko.plugin.archapi.basic.model.dataapi.IQueue;
import ru.volnenko.plugin.archapi.basic.model.dataapi.IStorage;
import ru.volnenko.plugin.archapi.basic.model.dataapi.ITopic;

public final class SchemeContext implements ISchemeContext {

    @NonNull
    @Override
    public ISchemeContext append(@NonNull IService service) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IUser user) {
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

    @Override
    public @NonNull ISchemeContext append(@NonNull ITopic topic) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IQueue queue) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull ISystem system) {
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
}
