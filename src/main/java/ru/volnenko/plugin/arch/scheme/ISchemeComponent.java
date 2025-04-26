package ru.volnenko.plugin.arch.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.archapi.model.IServer;

public interface ISchemeComponent extends ISchemeContext {

    @NonNull
    ISchemeComponent append(@NonNull IServer server);

}
