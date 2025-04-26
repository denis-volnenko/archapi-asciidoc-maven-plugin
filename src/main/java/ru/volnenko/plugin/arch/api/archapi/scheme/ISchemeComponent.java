package ru.volnenko.plugin.arch.api.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.api.archapi.model.IServer;

public interface ISchemeComponent extends ISchemeContext {

    @NonNull
    ISchemeComponent append(@NonNull IServer server);

}
