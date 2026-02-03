package com.example.bikemanagementsystem.controller;

import com.example.bikemanagementsystem.model.BikeModel;
import com.example.bikemanagementsystem.service.BikeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    private final BikeService service;

    public BikeController(BikeService service) {
        this.service = service;
    }

    @PostMapping("/add-bike")
    public BikeModel addBike(@Valid @RequestBody BikeModel bike) {
        return service.addBike(bike);
    }

    @GetMapping("/get-bike")
    public List<BikeModel> getBike() {
        return service.getBike();
    }

    @PutMapping("/update-bike/{id}")
    public BikeModel updateBike(@PathVariable String id, @RequestBody BikeModel bike) {
        return service.updateBike(id, bike);
    }

    @DeleteMapping("/delete-bike/{id}")
    public void deleteBike(@PathVariable String id) {
        service.deleteBike(id);
    }
}

