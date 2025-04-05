package ru.volnenko.plugin.archapi.model.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public final class OperationView {

    private String title = "";

    private String description = "";

    private List<Link> links = new ArrayList<>();

    private List<Note> notes = new ArrayList<>();

}
