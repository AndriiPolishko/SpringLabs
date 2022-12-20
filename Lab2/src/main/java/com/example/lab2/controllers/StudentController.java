package com.example.lab2.controllers;

import com.example.lab2.entities.Activity;
import com.example.lab2.entities.Student;
import com.example.lab2.repositories.ActivityRepository;
import com.example.lab2.services.ActivityService;
import com.example.lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ActivityService activityService;
    @GetMapping("/{id}")
    public String studentInfo(@PathVariable int id, Model model) {
        Student student = studentService.getStudent(id);
        ArrayList<Activity> allActivities = activityService.getAllActivities();
        List<Activity> filteredActivities = allActivities.stream().filter(activity -> activity.getStudentId() == id).toList();
        model.addAttribute("name", student.getName());
        model.addAttribute("activities", filteredActivities);
        return "other/info";
    }

}
