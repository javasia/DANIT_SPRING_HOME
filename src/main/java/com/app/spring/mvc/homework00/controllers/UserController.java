package com.app.spring.mvc.homework00.controllers;

import com.app.spring.mvc.homework00.entities.User;
import com.app.spring.mvc.homework00.repositories.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "/users")
public class UserController {

    private final Repository REPOSITORY;

    public UserController(Repository repository) {
        this.REPOSITORY = repository;
    }

//    @GetMapping
//    public String rederUser(@RequestParam(name = "id", required = true) String id, Model model) {
//        User user = REPOSITORY.getUserById(Long.parseLong(id));
//        model.addAttribute("user", user);
//        String[] subjects = getSubjectsString(user);
//        model.addAttribute("subjects", subjects);
//        return "user";
//    }

    @GetMapping
    public String renderAllUsers(Model model) {
        model.addAttribute("users", REPOSITORY.getUsers());
        return "all_users.html";
    }
}
