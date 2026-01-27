package com.example.day3studentmanagementsystem.service;

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
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
    //display student
    public List<StudentModel> getStudent(){
        return repository.findAll();
    }
    //update student
    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent = repository.findById(id).orElseThrow(()-> new RuntimeException("No student found"));
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());

        return repository.save(existingStudent);
    }
    //delete student
    public void deleteStudent(String id){
        StudentModel existingStudent = repository.findById(id).orElseThrow(() -> new RuntimeException("No student found"));
        repository.deleteById(id);
    }
}
