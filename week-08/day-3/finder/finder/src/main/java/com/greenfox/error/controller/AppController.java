package com.greenfox.error.controller;

import com.greenfox.error.model.User;
import com.greenfox.error.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by aze on 25/10/17.
 */
@Controller
@RequestMapping("/app")
public class AppController {

    UserService service;

    @Autowired
    public AppController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("new_user", new User());
        model.addAttribute("users", service.getAll());
        return "index";
    }

    @PostMapping("/app")
    public String create(@RequestParam String firstName, @RequestParam String lastName) {
        service.save(new User(firstName, lastName));
        return "redirect:/app";
    }
}