package com.example.goride.model;

public interface PaymentMethod {
    String getPaymentId();
    String getStatus();
    void makePayment(double amount);
}