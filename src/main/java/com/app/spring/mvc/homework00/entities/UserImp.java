package com.app.spring.mvc.homework00.entities;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UserImp implements User{
    private final long ID;
    private final String NAME;
    private Map<String, List<Integer>> subjects;

    public long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public Map<String, List<Integer>> getSubjects() {
        return subjects;
    }

    public UserImp(long id, String name) {
        this(id, name, new TreeMap<String, List<Integer>>());
    }

    public UserImp(long id, String name, Map<String, List<Integer>> subjects) {
        this.ID = id;
        this.NAME = name;
        this.subjects = subjects;
    }

    public void putSubject(Subject subject){
        subjects.put(subject.getNAME(), subject.getMarks());
    }

    public void removeSubjectByName(String name){
        subjects.remove(name);
    }

    @Override
    public String toString() {
        return "UserImp{" + "ID=" + ID + ", NAME='" + NAME + '\'' + ", subjects=" + subjects + '}';
    }
}
