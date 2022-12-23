package com.example.lab2.controllers;

import com.example.lab2.entities.Activity;
import com.example.lab2.entities.Student;
import com.example.lab2.services.ActivityService;
import com.example.lab2.services.LessonService;
import com.example.lab2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherControllers {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/createActivity")
    public String activityForm(Model model) {
        model.addAttribute("activity", new Activity());
        return "forms/activityForm";
    }

    @PostMapping("/createActivity")
    @ResponseBody
    public String activityCreate(@Valid @ModelAttribute Activity activity) {
        activityService.addActivity(activity);
        return "Activity added";
    }
}
