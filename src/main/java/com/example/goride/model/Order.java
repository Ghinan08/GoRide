package com.example.goride.model;

public class Order implements RideAction {
    private int id;
    private int userId;
    private int driverId;
    private String status;
    private double fare;

    public Order(int id, int userId, int driverId, String status, double fare) {
        this.id = id;
        this.userId = userId;
        this.driverId = driverId;
        this.status = status;
        this.fare = fare;
    }

    public void complete() {
        this.status = "Completed";
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    @Override
    public void startRide() {
        this.status = "In Progress";
    }

    @Override
    public void endRide() {
        this.status = "Completed";
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getStatus() {
        return status;
    }

    public double getFare() {
        return fare;
    }
}