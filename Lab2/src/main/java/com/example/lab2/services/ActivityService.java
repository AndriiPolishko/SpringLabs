package com.example.lab2.services;

import com.example.lab2.entities.Activity;
import com.example.lab2.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public void addActivity(Activity activity) {
        activityRepository.store(activity);
    }

    public Activity getActivity(int id) {
        return activityRepository.retrieve(id);
    }
    public ArrayList<Activity> getAllActivities() {
        return activityRepository.getAllActivities();
    }

}
