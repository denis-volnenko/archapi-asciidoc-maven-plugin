package ru.volnenko.plugin.archapi.scheme.impl;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.*;
import ru.volnenko.plugin.archapi.scheme.ISchemeContext;

public final class SchemeContext implements ISchemeContext {

    @NonNull
    @Override
    public ISchemeContext append(@NonNull IService service) {
        return null;
    }

    @Override
    public @NonNull ISchemeContext append(@NonNull IServer server) {
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
}
