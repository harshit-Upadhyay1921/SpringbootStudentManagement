package com.example.day3studentmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
package com.example.day3studentmanagementsystem.model;

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
    private String name;
    private String model;
}


