package com.example.goride.controller;

import com.example.goride.model.RideRequest;
import com.example.goride.model.User;
import com.example.goride.repository.RideRequestService;
import com.example.goride.service.FareCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/rides")
public class RideRequestController {
    private final RideRequestService rideRequestService;

    public RideRequestController(RideRequestService rideRequestService) {
        this.rideRequestService = rideRequestService;
    }

    @GetMapping("/new")
    public String showRideForm(Model model) {
        model.addAttribute("rideRequest", new RideRequest());
        model.addAttribute("locations", rideRequestService.getAvailableLocations());
        return "user/ride_form";
    }

    @PostMapping("/new")
    public String submitRideRequest(@ModelAttribute RideRequest rideRequest,
                                  @RequestParam Long userId,
                                  Model model) {
        User dummyUser = new User(userId, null, 0, null);
        dummyUser.setName("Dummy User");
        rideRequest.setUser(dummyUser);
        rideRequest.setStatus("PENDING");

        rideRequestService.save(rideRequest);
        model.addAttribute("message", "Ride request submitted successfully!");
        model.addAttribute("locations", rideRequestService.getAvailableLocations());
        return "user/ride_form";
    }

    @ResponseBody
    @GetMapping("/calculate-fare")
    public ResponseEntity<?> calculateFare(
            @RequestParam String pickup,
            @RequestParam String destination,
            @RequestParam String rideType) {
        try {
            FareCalculator.FareDetails fareDetails = rideRequestService
                .calculateFareDetails(pickup, destination, rideType);
            return ResponseEntity.ok(fareDetails);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "Gagal menghitung tarif", "details", e.getMessage()));
        }
    }
}