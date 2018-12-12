package com.app.spring.mvc.homework00.repositories;

import com.app.spring.mvc.homework00.entities.User;

import java.util.Map;

public interface Repository {
    Map<Long, User> getUsers();
    User getUserById(long id);
    void putUser(User entity);
    void deleteUserById(long id);
}
