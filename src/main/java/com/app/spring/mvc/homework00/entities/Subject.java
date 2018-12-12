package com.app.spring.mvc.homework00.entities;


import java.util.List;

public class Subject {
    private final String NAME;
    private List<Integer> marks;

    public Subject(String name, List<Integer> marks) {
        this.NAME = name;
        this.marks = marks;
    }

    public String getNAME() {
        return NAME;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Subject{" + "NAME='" + NAME + '\'' + ", marks=" + marks + '}';
    }
}