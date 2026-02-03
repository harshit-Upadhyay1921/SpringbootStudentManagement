package com.example.bikemanagementsystem.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bikes")
public class BikeModel {

    @Id
    private String id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private String brand;
}

