package ru.volnenko.plugin.arch.basic.scheme;

import lombok.NonNull;
import ru.volnenko.plugin.arch.basic.model.IServer;

public interface ISchemeComponent extends ISchemeContext {

    @NonNull
    ISchemeComponent append(@NonNull IServer server);

}
