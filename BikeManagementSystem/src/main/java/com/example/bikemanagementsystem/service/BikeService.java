package com.example.bikemanagementsystem.service;

import com.example.bikemanagementsystem.model.BikeModel;
import com.example.bikemanagementsystem.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private BikeRepository repository;

    public BikeService(BikeRepository repository) {
        this.repository = repository;
    }

    public BikeModel addBike(BikeModel bike) {
        return repository.save(bike);
    }

    // display bikes
    public List<BikeModel> getBike() {
        return repository.findAll();
    }

    // update bike
    public BikeModel updateBike(String id, BikeModel bike) {
        BikeModel existingBike = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No bike found"));

        existingBike.setName(bike.getName());
        existingBike.setBrand(bike.getBrand());

        return repository.save(existingBike);
    }

    // delete bike
    public void deleteBike(String id) {
        BikeModel existingBike = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No bike found"));
        repository.deleteById(id);
    }
}

