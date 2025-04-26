package ru.volnenko.plugin.arch.basic.model;

import ru.volnenko.plugin.arch.basic.model.archapi.impl.Note;
import ru.volnenko.plugin.arch.basic.model.archapi.impl.EnvironmentReference;

import java.util.List;

public interface IContextView {

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    List<Note> getNotes();

    void setNotes(List<Note> notes);

    EnvironmentReference getEnvironmentReference();

    void setEnvironmentReference(EnvironmentReference environmentReference);

}
