package com.example.lab2.controllers;

import com.example.lab2.entities.Lesson;
import com.example.lab2.repositories.LessonRepository;
import com.example.lab2.entities.Student;
import com.example.lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherControllers {
    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("/createStudent")
    String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/studentForm";
    }

    @PostMapping("/createStudent")
    @ResponseBody
    String studentCreated(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "Student Created";
    }

    @GetMapping("/createLesson")
    String lessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "lessonForm";
    }

    @PostMapping("/createLesson")
    @ResponseBody
    String lessonCreate(@ModelAttribute Lesson lesson) {
        lessonRepository.store(lesson);
        return "Lesson created";
    }
}
