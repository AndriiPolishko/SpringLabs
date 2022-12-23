package com.example.lab2.services;

import com.example.lab2.entities.Student;
import com.example.lab2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.store(student);
    }

    public Student getStudent(int id) {
        return studentRepository.retrieve(id);
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public void deleteStudent(int id) {
        if (studentRepository.retrieve(id) != null) {
            studentRepository.delete(id);
        }
    }

    public void updateStudent(int id, Student newStudent) {studentRepository.update(id, newStudent);}

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(int id, int size) {
        return studentRepository.findAll(id, size);
    }
}
