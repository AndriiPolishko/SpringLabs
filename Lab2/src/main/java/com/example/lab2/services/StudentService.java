package com.example.lab2.services;

import com.example.lab2.entities.Student;
import com.example.lab2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.store(student);
    }
    public void deleteStudent(int studentId) {
        studentRepository.delete(studentId);
    }
}
