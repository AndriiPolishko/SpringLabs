package com.example.lab2.controllers;

import com.example.lab2.entities.Activity;
import com.example.lab2.repositories.ActivityRepository;
import com.example.lab2.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class JournalController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/journal/show")
    String showJournal(Model model) {
        ArrayList<Activity> activities = activityService.getAllActivities();
        model.addAttribute("activities", activities);
        return "other/journal";
    }
}
