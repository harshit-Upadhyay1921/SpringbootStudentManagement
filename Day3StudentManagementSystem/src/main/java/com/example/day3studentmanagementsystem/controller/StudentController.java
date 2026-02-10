package com.example.day3studentmanagementsystem.controller;



import com.example.day3studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3studentmanagementsystem.dto.StudentResponseDto;
import com.example.day3studentmanagementsystem.model.StudentModel;
import com.example.day3studentmanagementsystem.service.StudentService;
import com.example.day3studentmanagementsystem.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    private final StudentService service;
    private final JwtUtil jwtUtil;

    public StudentController(StudentService service,JwtUtil jwtUtil){
        this.service=service;
        this.jwtUtil=jwtUtil;
    }

    private void chechToken(String authHeader){
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid token");
        }
        String token=authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }


    @PostMapping("/add-student")
    public StudentResponseDto addStudent(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }
    @GetMapping("/get-student")
    public List<StudentResponseDto> getStudent(

            @RequestHeader( value="Authorization",required=false) String authHeader
    ){
        chechToken(authHeader);
        return service.getStudent();
    }
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id,@Valid @RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
    }

}
