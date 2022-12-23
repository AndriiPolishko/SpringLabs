package com.example.lab2.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.lab2.entities.Student;

@Repository
public class StudentRepository implements ObjectRepository<Student> {

    private final Map<Integer, Student> repository;

    public StudentRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void store(Student student) {
        repository.put(student.getId(), student);
    }

    @Override
    public Student retrieve(int id) {
        return repository.get(id);
    }


    @Override
    public Student delete(int id) {
        Student e = repository.get(id);
        repository.remove(id);
        return e;
    }

}