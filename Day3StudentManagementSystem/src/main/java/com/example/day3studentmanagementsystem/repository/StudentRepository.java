package com.example.day3studentmanagementsystem.repository;

import com.example.day3studentmanagementsystem.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel,String>{

}
