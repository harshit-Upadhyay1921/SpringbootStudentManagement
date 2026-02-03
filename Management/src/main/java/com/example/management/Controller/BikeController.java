package com.example.management.Controller;

import com.example.management.Model.BikeModel;
import com.example.management.Service.BikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController {

    private final BikeService service;

    public BikeController(BikeService Service) {
        this.service = service;
    }

    @PostMapping("/add-bike")
    public BikeModel addBike(@RequestBody BikeModel bike) {
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

