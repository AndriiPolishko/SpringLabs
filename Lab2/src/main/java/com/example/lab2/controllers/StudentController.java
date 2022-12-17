package com.example.lab2.controllers;

import com.example.lab2.entities.Student;
import com.example.lab2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/findStudent")
    private String studentMainPage() {
        return "student/student";
    }
    @GetMapping("/info")
    String studentInfo(int id, Model model) {
        Student student = studentRepository.retrieve(id);
        model.addAttribute("id", student.getId());
        model.addAttribute("name", student.getName());
        return "student/info";
    }

}
