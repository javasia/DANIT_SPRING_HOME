package com.app.spring.mvc.homework00.db;

public interface DB {
    String[] select (String table);
    String select (String table, Long id);
}
