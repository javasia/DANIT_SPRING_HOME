package com.app.spring.mvc.homework00.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {
    @GetMapping("/")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        return new RedirectView("users");
    }
}



