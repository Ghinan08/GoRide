package com.example.goride.repository;

import com.example.goride.model.RideRequest;
import com.example.goride.service.DistanceCalculator;
import com.example.goride.service.FareCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideRequestService {
    private final DistanceCalculator distanceCalculator;
    private final FareCalculator fareCalculator;
    private static final Logger logger = LoggerFactory.getLogger(RideRequestService.class);
    private List<RideRequest> rides = new ArrayList<>();
    private long idCounter = 1;
    
    @Autowired
    public RideRequestService(DistanceCalculator distanceCalculator, FareCalculator fareCalculator) {
        this.distanceCalculator = distanceCalculator;
        this.fareCalculator = fareCalculator;
    }

    public RideRequest save(RideRequest rideRequest) {
        if (rideRequest.getId() == 0) {
            rideRequest.setId(idCounter++);
        }
        rides.add(rideRequest);
        return rideRequest;
    }

    public List<RideRequest> findAll() {
        return rides;
    }

    public List<RideRequest> findByUserId(Long userId) {
        return rides.stream()
            .filter(r -> r.getUser() != null && r.getUser().getId().equals(userId))
            .collect(Collectors.toList());
    }

    public List<String> getAvailableLocations() {
        return List.of(
            "Jl. Thamrin No. 10",
            "Plaza Senayan",
            "Kemang Raya", 
            "Blok M Square",
            "Grand Indonesia",
            "Kuningan City"
        );
    }

    public FareCalculator.FareDetails calculateFareDetails(String pickup, String destination, String rideType) {
        logger.info("Calculating fare from {} to {} with type {}", pickup, destination, rideType);
        
        try {
            int distance = distanceCalculator.getDistance(pickup, destination);
            logger.info("Distance calculated: {} km", distance);
            
            FareCalculator.FareDetails fareDetails = fareCalculator.calculateFare(rideType, distance);
            logger.info("Fare calculation successful - Total: {}", fareDetails.getTotalFare());
            
            return fareDetails;
        } catch (Exception e) {
            logger.error("Error calculating fare", e);
            throw e;
        }
    }
}