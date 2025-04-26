package ru.volnenko.plugin.arch.component.techapi;

import lombok.NonNull;
import ru.volnenko.plugin.arch.component.techapi.model.*;

import java.util.Map;

public interface ITechComponents {

    @NonNull
    Map<String, IFramework> frameworks();

    @NonNull
    Map<String, ILanguage> languages();

    @NonNull
    Map<String, ILibrary> libraries();

    @NonNull
    Map<String, IPlatform> platforms();

    @NonNull
    Map<String, ITool> tools();

}
