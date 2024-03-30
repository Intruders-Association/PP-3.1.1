package com.alb.spring.mvc.springboot.controller;

import com.alb.spring.mvc.springboot.model.User;
import com.alb.spring.mvc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping({"/list"})
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUserTable());
        return "list";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String editUser(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.findUser(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/list";
    }
}
