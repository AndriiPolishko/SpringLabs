package com.example.lab2.student;

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
    public void deleteStudent(Student student) {
        studentRepository.delete(student.getId());
    }
}
