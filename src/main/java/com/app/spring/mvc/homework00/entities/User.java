package com.app.spring.mvc.homework00.entities;

import java.util.Map;

public class User {
    private final long ID;
    private final String NAME;
    private Map<Long, Subject> subjects;

    public User(long id, String name) {
        ID = id;
        NAME = name;
    }

    public boolean putSubject(Subject subject){
        return false;
    }

    public boolean removeSubjectById(long id){
        return false;
    }
}
