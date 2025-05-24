package com.example.goride.model;

public class Route implements RideAction {
    private double distance;
    private double duration;

    public Route(double distance, double duration) {
        this.distance = distance;
        this.duration = duration;
    }

    public double estimateFare() {
        // Simple fare calculation based on distance
        return distance * 2000; // Rp 2,000 per km
    }

    public double calculateEta() {
        // Simple ETA calculation based on distance and average speed (40 km/h)
        return (distance / 40) * 60; // in minutes
    }

    @Override
    public void startRide() {
        // Implementation for startRide
    }

    @Override
    public void endRide() {
        // Implementation for endRide
    }

    // Getters and Setters
    public double getDistance() {
        return distance;
    }

    public double getDuration() {
        return duration;
    }
}