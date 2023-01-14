package com.example.lab2.services;

import com.example.lab2.entities.Student;
import com.example.lab2.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public Optional<Student> getUserById(Long id) {
        return this.studentRepository.findById(id);
    }

    public List<Student> getUsers() {
        return (List<Student>) this.studentRepository.findAll();
    }


    public List<Student> getUsersOrderedByEmail() {
        return this.studentRepository.findAllOrderedByEmail();
    }
}
