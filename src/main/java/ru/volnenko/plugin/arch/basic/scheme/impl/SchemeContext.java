package ru.volnenko.plugin.arch.basic.scheme.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.model.*;
import ru.volnenko.plugin.arch.basic.scheme.ISchemeContext;
import ru.volnenko.plugin.arch.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.basic.model.archapi.ISystem;
import ru.volnenko.plugin.arch.dataapi.model.IQueue;
import ru.volnenko.plugin.arch.dataapi.model.IStorage;
import ru.volnenko.plugin.arch.dataapi.model.ITopic;

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
