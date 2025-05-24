package com.example.goride.controller;

import com.example.goride.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        User user = new User(1, "John Doe", 123456789, "john@example.com");
        model.addAttribute("user", user);
        return "user/dashboard";
    }
}