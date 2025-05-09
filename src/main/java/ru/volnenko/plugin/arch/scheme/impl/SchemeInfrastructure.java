package ru.volnenko.plugin.arch.scheme.impl;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.model.*;
import ru.volnenko.plugin.arch.component.archapi.model.archapi.ISystem;
import ru.volnenko.plugin.arch.scheme.ISchemeInfrastructure;
import ru.volnenko.plugin.arch.archapi.model.*;
import ru.volnenko.plugin.arch.scheme.ISchemeContext;
import ru.volnenko.plugin.arch.component.dataapi.model.IDataBase;
import ru.volnenko.plugin.arch.component.archapi.model.archapi.IBalancer;
import ru.volnenko.plugin.arch.component.dataapi.model.IQueue;
import ru.volnenko.plugin.arch.component.dataapi.model.IStorage;
import ru.volnenko.plugin.arch.component.dataapi.model.ITopic;
import ru.volnenko.plugin.arch.scheme.ISchemeComponent;

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

    @Override
    public @NonNull ISchemeComponent append(@NonNull IServer server) {
        return null;
    }

    @Override
    public @NonNull ISchemeComponent append(@NonNull IBalancer balancer) {
        return null;
    }
}
