package com.example.day3studentmanagementsystem.service;

import com.example.day3studentmanagementsystem.dto.StudentRequestDto;
import com.example.day3studentmanagementsystem.dto.StudentResponseDto;
import com.example.day3studentmanagementsystem.exception.StudentNotFoundException;
import com.example.day3studentmanagementsystem.model.StudentModel;
import com.example.day3studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository repository;
    public StudentService(StudentRepository repository){

        this.repository = repository;
    }

    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }
    //display student
    public List<StudentResponseDto> getStudent(){

        return repository.findAll()
                .stream()
                .map( s -> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }
    //update student
    public StudentResponseDto updateStudent(String id,StudentRequestDto student){
        StudentModel existingStudent = repository.findById(id).orElseThrow(()-> new StudentNotFoundException("No student found"));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());

        StudentModel newStudent = repository.save(existingStudent);

        return new StudentResponseDto(
                newStudent.getId(),
                newStudent.getName(),
                newStudent.getAge(),
                newStudent.getEmail()
        );

    }
    //delete student
    public void deleteStudent(String id){
        StudentModel existingStudent = repository.findById(id).orElseThrow(() -> new StudentNotFoundException("No student found"));
        repository.deleteById(id);
    }
}
