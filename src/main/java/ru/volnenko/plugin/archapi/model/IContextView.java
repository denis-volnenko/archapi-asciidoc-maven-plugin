package ru.volnenko.plugin.archapi.model;

import ru.volnenko.plugin.archapi.model.impl.EnvironmentReference;
import ru.volnenko.plugin.archapi.model.impl.Note;

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
