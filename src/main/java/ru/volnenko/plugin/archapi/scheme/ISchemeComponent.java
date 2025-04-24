package ru.volnenko.plugin.archapi.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.model.IServer;

public interface ISchemeComponent extends ISchemeContext {

    @NonNull
    ISchemeComponent append(@NonNull IServer server);

}
