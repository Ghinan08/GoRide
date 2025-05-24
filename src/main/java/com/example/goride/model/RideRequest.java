
package com.example.goride.model;

public class RideRequest implements RideAction {
    private int userId;
    private String pickupLocation;
    private String destination;

    public RideRequest(int userId, String pickupLocation, String destination) {
        this.userId = userId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
    }

    public void createRequest() {
        System.out.println("Ride request created.");
    }

    public void cancelRequest() {
        System.out.println("Ride request cancelled.");
    }

    @Override
    public void startRide() {
        System.out.println("Ride started.");
    }

    @Override
    public void endRide() {
        System.out.println("Ride ended.");
    }
}
