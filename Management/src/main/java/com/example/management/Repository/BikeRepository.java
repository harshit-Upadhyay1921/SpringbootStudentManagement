package com.example.management.repository;

import com.example.management.model.BikeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends MongoRepository<BikeModel, String> {

}
