package com.example.lab2.controllers;

import com.example.lab2.entities.Activity;
import com.example.lab2.entities.Lesson;
import com.example.lab2.entities.Student;
import com.example.lab2.services.ActivityService;
import com.example.lab2.services.LessonService;
import com.example.lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherControllers {
    @Autowired
    private StudentService studentService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private ActivityService activityService;

    @GetMapping("/createStudent")
    public String studentForm(Model model) {
        model.addAttribute("student", new Student());
        return "forms/studentForm";
    }

    @PostMapping("/createStudent")
    @ResponseBody
    public String studentCreate(@Valid @ModelAttribute Student student) {
        studentService.addStudent(student);
        return "forms/studentForm";
    }

    @GetMapping("/createLesson")
    public String lessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "forms/lessonForm";
    }

    @PostMapping("/createLesson")
    @ResponseBody
    public String lessonCreate(@Valid @ModelAttribute Lesson lesson) {
        lessonService.addLesson(lesson);
        return "Lesson created";
    }

    @GetMapping("/createActivity")
    public String activityForm(Model model) {
        model.addAttribute("activity", new Activity());
        return "forms/activityForm";
    }

    @PostMapping("/createActivity")
    @ResponseBody
    public String activityCreate(@Valid@ModelAttribute Activity activity) {
        activityService.addActivity(activity);
        return "Activity added";
    }
}
