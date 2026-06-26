package ru.volnenko.plugin.arch.model;

import lombok.NonNull;

public interface IGroupId {

    String getGroupId();

    void setGroupId(String groupId);

    @NonNull
    String groupId();

}
