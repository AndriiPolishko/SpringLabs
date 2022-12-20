package com.example.lab2.services;

import com.example.lab2.entities.Student;
import com.example.lab2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.store(student);
    }

    public Student getStudent(int id) {
        return studentRepository.retrieve(id);
    }

    public void deleteStudent(int studentId) {
        studentRepository.delete(studentId);
    }
}
