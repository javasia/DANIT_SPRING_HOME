package com.app.spring.mvc.homework00;

import com.app.spring.mvc.homework00.entities.User;

import java.util.Set;

public interface UserRepository {
    Set<User> getAllUsers();
    User getUserById(long id);
    boolean putUser(User user);
    boolean deleteUserById(long id);
}
