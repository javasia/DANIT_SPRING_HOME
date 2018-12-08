package com.app.spring.mvc.homework00.entities;

public class Subject {
    private final long ID;
    private final String NAME;
    private final int GRADE;

    public Subject(long id, String name, int grade) {
        ID = id;
        NAME = name;
        GRADE = grade;
    }
}