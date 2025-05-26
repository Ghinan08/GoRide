package com.example.goride.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculator {
    private final Map<String, Map<String, Integer>> distanceMatrix;

    public DistanceCalculator() {
        distanceMatrix = new HashMap<>();
        initializeDistances();
    }

    private void initializeDistances() {
        addDistance("Jl. Thamrin No. 10", "Plaza Senayan", 2);
        addDistance("Jl. Thamrin No. 10", "Kemang Raya", 8);
        addDistance("Jl. Thamrin No. 10", "Blok M Square", 3);
        addDistance("Jl. Thamrin No. 10", "Grand Indonesia", 4);
        addDistance("Jl. Thamrin No. 10", "Kuningan City", 15);
        
        addDistance("Plaza Senayan", "Grand Indonesia", 30);
        addDistance("Plaza Senayan", "Kuningan City", 18);
        addDistance("Plaza Senayan", "Kemang Raya", 10);
        
        addDistance("Kemang Raya", "Blok M Square", 6);
        addDistance("Kemang Raya", "Grand Indonesia", 12);
        
        addDistance("Blok M Square", "Grand Indonesia", 8);
        
        addDistance("Grand Indonesia", "Kuningan City", 25);
    }

    private void addDistance(String from, String to, int distance) {
        distanceMatrix.computeIfAbsent(from, k -> new HashMap<>()).put(to, distance);
        distanceMatrix.computeIfAbsent(to, k -> new HashMap<>()).put(from, distance);
    }

    public int getDistance(String from, String to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Lokasi tidak boleh null");
        }
        if (from.equals(to)) {
            return 0;
        }
        
        if (!distanceMatrix.containsKey(from)) {
            throw new IllegalArgumentException("Lokasi awal tidak ditemukan: " + from);
        }
        
        if (!distanceMatrix.get(from).containsKey(to)) {
            throw new IllegalArgumentException("Rute dari " + from + " ke " + to + " tidak tersedia");
        }
        
        return distanceMatrix.get(from).get(to);
    }
}