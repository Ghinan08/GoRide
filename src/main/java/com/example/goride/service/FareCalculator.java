package com.example.goride.service;

import org.springframework.stereotype.Service;

@Service
public class FareCalculator {
    private static final int REGULAR_BASE_FARE = 10000;
    private static final int PREMIUM_BASE_FARE = 15000;
    private static final int XL_BASE_FARE = 20000;
    
    private static final int REGULAR_RATE_PER_KM = 2500;
    private static final int PREMIUM_RATE_PER_KM = 3500;
    private static final int XL_RATE_PER_KM = 4500;

    public FareDetails calculateFare(String rideType, int distance) {
        int baseFare;
        int ratePerKm;
        
        switch (rideType.toLowerCase()) {
            case "premium":
                baseFare = PREMIUM_BASE_FARE;
                ratePerKm = PREMIUM_RATE_PER_KM;
                break;
            case "xl":
                baseFare = XL_BASE_FARE;
                ratePerKm = XL_RATE_PER_KM;
                break;
            default: // regular
                baseFare = REGULAR_BASE_FARE;
                ratePerKm = REGULAR_RATE_PER_KM;
        }
        
        int distanceFare = distance * ratePerKm;
        int totalFare = baseFare + distanceFare;
        int duration = distance * 3; // Estimasi 3 menit per km
        
        return new FareDetails(distance, duration, baseFare, distanceFare, totalFare);
    }
    
    public static class FareDetails {
        private final int distance;
        private final int duration;
        private final int baseFare;
        private final int distanceFare;
        private final int totalFare;

        public FareDetails(int distance, int duration, int baseFare, int distanceFare, int totalFare) {
            this.distance = distance;
            this.duration = duration;
            this.baseFare = baseFare;
            this.distanceFare = distanceFare;
            this.totalFare = totalFare;
        }

        // Getter methods
        public int getDistance() { return distance; }
        public int getDuration() { return duration; }
        public int getBaseFare() { return baseFare; }
        public int getDistanceFare() { return distanceFare; }
        public int getTotalFare() { return totalFare; }
    }
}