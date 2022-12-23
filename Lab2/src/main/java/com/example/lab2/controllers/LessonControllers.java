package com.example.lab2.controllers;

import com.example.lab2.entities.Lesson;
import com.example.lab2.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/lesson")
public class LessonControllers {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/create")
    public String lessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        return "forms/lessonForm";
    }

    @PostMapping("/create")
    @ResponseBody
    public String lessonCreate(@Valid @ModelAttribute Lesson lesson) {
        lessonService.addLesson(lesson);
        return "Lesson created";
    }

}
