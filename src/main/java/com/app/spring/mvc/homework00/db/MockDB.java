package com.app.spring.mvc.homework00.db;

public class MockDB implements DB {
    private static final String[] USERS = new String[]{
            "0;Andrii Dancheko;Math:3,3,4+Physics:5,5,5,5",
            "1;John Doe;Literature:5+Computer science:2,2,2,2,2",
            "2;Robot Z; Cinematography:5,5,5+Literature:5,5+Math:2"};

    public String[] select(String table) {
        return this.USERS;
    }

    public String select(String table, Long id) {
        return null;
    }
}
