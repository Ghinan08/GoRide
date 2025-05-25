package com.example.goride.model;

public class User extends Person {

    public User(Long id, String name, int phone, String email) {
        super(id, name, phone, email);
    }

    public void requestId() {
        System.out.println("User requesting ID...");
    }

    public void viewRideHistory() {
        System.out.println("Viewing ride history...");
    }

    public String getRide() {
        return "Sample Ride";
    }

    @Override
    public String getRole() {
        return "User";
    }

    public void setId(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public void setName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }
}
