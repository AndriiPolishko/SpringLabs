package com.example.lab2.repositories;

import com.example.lab2.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

@Repository
public interface  StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByEmail(String email);

    @Query("SELECT u FROM student u WHERE u.first_name=?1 AND u.second_name=?2")
    List<Student> findByFirstNameAndSecondName(String firstName, String secondName);

    List<Student> findAllOrderedByEmail();


}