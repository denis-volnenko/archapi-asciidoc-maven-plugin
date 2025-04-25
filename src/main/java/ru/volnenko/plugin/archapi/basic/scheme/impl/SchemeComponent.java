package ru.volnenko.plugin.archapi.basic.scheme.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.model.*;
import ru.volnenko.plugin.archapi.basic.scheme.ISchemeComponent;
import ru.volnenko.plugin.archapi.basic.scheme.ISchemeContext;
import ru.volnenko.plugin.archapi.dataapi.model.IDataBase;
import ru.volnenko.plugin.archapi.model.*;
import ru.volnenko.plugin.archapi.basic.model.archapi.ISystem;
import ru.volnenko.plugin.archapi.dataapi.model.IQueue;
import ru.volnenko.plugin.archapi.dataapi.model.IStorage;
import ru.volnenko.plugin.archapi.dataapi.model.ITopic;

public final class SchemeComponent implements ISchemeComponent {

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

}
