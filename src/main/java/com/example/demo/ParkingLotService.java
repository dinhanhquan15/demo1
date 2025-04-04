package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private static final int MAX_SIZE = 50;

    public void addVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (vehicle.getLicensePlate() == null || vehicle.getLicensePlate().trim().isEmpty()) {
            throw new IllegalArgumentException("Biển số xe không được để trống!");
        }
        if (vehicles.stream().anyMatch(v -> v.getLicensePlate().equals(vehicle.getLicensePlate()))) {
            throw new IllegalArgumentException("Biển số xe " + vehicle.getLicensePlate() + " đã tồn tại!");
        }
        if (vehicles.size() >= MAX_SIZE) {
            throw new IllegalArgumentException("Bãi xe đầy!");
        }
        if (vehicle.getParkingHours() <= 0) {
            throw new IllegalArgumentException("Số giờ gửi xe phải lớn hơn 0!");
        }
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles);
    }

    public Vehicle findHighestFeeVehicle() {
        if (vehicles.isEmpty()) return null;
        return vehicles.stream()
                .max((v1, v2) -> Double.compare(v1.calculateFee(), v2.calculateFee()))
                .orElse(null);
    }

    public void removeVehicle(String ticketId) {
        vehicles.stream()
                .filter(v -> v.getTicketId().equals(ticketId))
                .findFirst().ifPresent(vehicles::remove);
    }
}
