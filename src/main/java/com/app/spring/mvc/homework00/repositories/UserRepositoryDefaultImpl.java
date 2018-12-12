package com.app.spring.mvc.homework00.repositories;

import com.app.spring.mvc.homework00.db.DB;
import com.app.spring.mvc.homework00.entities.Subject;
import com.app.spring.mvc.homework00.entities.User;
import com.app.spring.mvc.homework00.entities.UserImp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepositoryDefaultImpl implements Repository {

    private String USERS_DB_TABLE_NAME = "users";
    private Map<Long, User> users;

    private final DB DB;

    UserRepositoryDefaultImpl(DB db) {
        this.DB = db;
    }

    private void initUsers() {
        this.users = Arrays.stream(this.DB.select(USERS_DB_TABLE_NAME)).map(userDBFormattedString -> {
            String[] idNameSubject = userDBFormattedString.split(";");
            User user = new UserImp(Long.parseLong(idNameSubject[0]), idNameSubject[1]);
            String[] subjectsMarks = idNameSubject[2].split("\\+");
            Map<String, List<Integer>> subjects = Arrays.stream(subjectsMarks)
                    .collect(Collectors
                            .toMap(subject -> subject.split(":")[0], marks -> Arrays.stream(marks.split(":")[1]
                                    .split(","))
                                    .map(mark -> Integer.parseInt(mark))
                                    .collect(Collectors.toList())));
            subjects.keySet().forEach(key -> user.putSubject(new Subject(key, subjects.get(key))));
            return user;
        }).collect(Collectors.toMap(User::getID, user -> user));
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public User getUserById(long id) {
        return users.get(id);
    }

    public void putUser(User user) {
         users.put(user.getID(), user);
    }

    public void deleteUserById(long id) {
         users.remove(id);
    }
}
