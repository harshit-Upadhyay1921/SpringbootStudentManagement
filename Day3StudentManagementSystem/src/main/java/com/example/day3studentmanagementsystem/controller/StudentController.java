package com.example.day3studentmanagementsystem.controller;

import com.example.day3studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3studentmanagementsystem.dto.StudentResponseDto;
import com.example.day3studentmanagementsystem.model.StudentModel;
import com.example.day3studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
    @GetMapping("/get-student")
    public List<StudentResponseDto> getStudent(){

        return service.getStudent();
    }
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,@RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }
}
