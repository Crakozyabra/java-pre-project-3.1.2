package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@AllArgsConstructor
@RequestMapping("/")
@Slf4j
public class UserController {

    private UserService service;

    @GetMapping
    public String getAll(ModelMap model) {
        log.info("getAll");
        model.addAttribute("users", service.getAll());
        return "main";
    }

    @PostMapping("/users/{id}")
    public String delete(@PathVariable Long id) {
        log.info("delete");
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String getForm(@RequestParam(required = false) Long modifiedUserId, ModelMap model) {
        log.info("getForm");
        User user = Objects.isNull(modifiedUserId) ? new User() : service.get(modifiedUserId);
        model.addAttribute("user", user);
        return "form";
    }

    @PostMapping("/users")
    public String processForm(User user) {
        log.info("processForm");
        service.save(user);
        return "redirect:/";
    }
}