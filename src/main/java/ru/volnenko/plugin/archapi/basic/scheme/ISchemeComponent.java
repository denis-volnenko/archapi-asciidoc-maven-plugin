package ru.volnenko.plugin.archapi.basic.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.archapi.basic.model.IServer;

public interface ISchemeComponent extends ISchemeContext {

    @NonNull
    ISchemeComponent append(@NonNull IServer server);

}
