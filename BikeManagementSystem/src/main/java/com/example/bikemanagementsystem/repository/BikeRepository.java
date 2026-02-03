package com.example.bikemanagementsystem.repository;

import com.example.bikemanagementsystem.model.BikeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BikeRepository extends MongoRepository<BikeModel, String> {

}

