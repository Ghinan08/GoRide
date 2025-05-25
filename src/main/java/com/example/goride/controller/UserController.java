package com.example.goride.controller;

import com.example.goride.model.User;
import com.example.goride.repository.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final RideRequestService rideRequestService;
    
    @Autowired
    public UserController(RideRequestService rideRequestService) {
        this.rideRequestService = rideRequestService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("locations", rideRequestService.getAvailableLocations());
        model.addAttribute("user", getCurrentUser());
        return "user/dashboard";
    }

    private User getCurrentUser() {
        return new User(1L, "John Doe", 123456789, "john@example.com");
    }
}