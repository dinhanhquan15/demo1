package com.example.demo;

import java.time.LocalDateTime;

public class Vehicle {
    private String ticketId;
    private String vehicleName;
    private String licensePlate;
    private String ownerName;
    private String address;
    private LocalDateTime startTime;
    private int parkingHours;

    public Vehicle() {
        this.ticketId = "TICKET" + System.currentTimeMillis();
        this.startTime = LocalDateTime.now();
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public int getParkingHours() { return parkingHours; }
    public void setParkingHours(int parkingHours) { this.parkingHours = parkingHours; }

    public double calculateFee() {
        int hours = parkingHours;
        if (hours <= 4) return 60000;
        else if (hours <= 24) return 60000 + (hours - 4) * 10000;
        else return 200000;
    }
}
