package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "components/register-form"; 
    }

    @PostMapping("/create")
    public String handleCreateUser(User user, HttpSession session, Model model) {
        userService.registerUser(user); 
        session.setAttribute("user", user);
        return "redirect:/users/result";
    }

    @GetMapping("/result")
    public String showResultPage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "layout/result-register";
        } else {
            return "redirect:/users/create";
        }
    }
}
