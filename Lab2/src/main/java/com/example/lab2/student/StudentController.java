package com.example.lab2.student;

import com.example.lab2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student/findStudent")
    String studentMainPage() {
        return "student/student";
    }
    @GetMapping("/student/info")
    String studentInfo(int id, Model model) {
        Student gotStudent = studentRepository.retrieve(id);
        int studentId = gotStudent.getId();
        String studentName = gotStudent.getName();
        model.addAttribute("id", studentId);
        model.addAttribute("name", studentName);
        return "student/info";
    }

}
