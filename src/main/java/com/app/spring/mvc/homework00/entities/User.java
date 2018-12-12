package com.app.spring.mvc.homework00.entities;

import java.util.List;
import java.util.Map;

public interface User{
    long getID();
    String getNAME();
    Map<String, List<Integer>> getSubjects();
    void putSubject(Subject subject);
    void removeSubjectByName(String name);
}
