package com.example.goride.model;

public class Location {
    private double latitude;
    private double longitude;
    private String address;

    public Location(double latitude, double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public String getCoordinates() {
        return latitude + "," + longitude;
    }

    public void viewRideHistory() {
        // Implementation for viewRideHistory
    }

    // Getters and Setters
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }
}