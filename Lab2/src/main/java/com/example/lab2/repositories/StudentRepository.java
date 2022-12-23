package com.example.lab2.repositories;

import com.example.lab2.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void update(int id, Student newStudent) {
        repository.replace(id, newStudent);
    }

    public Student findByEmail(String email) {
        for (Student student: this.repository.values()) {
            if (student.getEmail() == email) {
                return student;
            }
        }
        return null;
    }

    public List<Student> findAll(int id, int size) {
        List<Student> res = new ArrayList<>();
        int counter = 0;
        for (Student student: this.repository.values()) {
            if(student.getId() == id || (counter > 0 && counter <= size)) {
                counter++;
                res.add(student);
            }
        }
        return res;
    }


}