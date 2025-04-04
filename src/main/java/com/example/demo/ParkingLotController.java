package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ParkingLotController {

    private ParkingLotService parkingLotService;

    // Trang chính (hiển thị form và danh sách xe)
    @GetMapping
    public String showParkingLot(Model model) {
        model.addAttribute("vehicles", parkingLotService.getAllVehicles());
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("highestFeeVehicle", parkingLotService.findHighestFeeVehicle());
        return "index"; // Trả về file index.html trong templates
    }

    // Thêm xe mới
    @PostMapping("/add")
    public String addVehicle(@ModelAttribute Vehicle vehicle, Model model) {
        try {
            parkingLotService.addVehicle(vehicle);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/vehicles"; // Chuyển hướng về trang chính
    }

    // Xóa xe
    @PostMapping("/remove")
    public String removeVehicle(@RequestParam String ticketId) {
        parkingLotService.removeVehicle(ticketId);
        return "redirect:/vehicles"; // Chuyển hướng về trang chính
    }
}
