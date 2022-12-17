package com.example.lab2.repositories;

import com.example.lab2.entities.Activity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ActivityRepository implements ObjectRepository<Activity> {
    private HashMap<Integer, Activity> repository;

    public ActivityRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void store(Activity activity) {
        repository.put(activity.getId(), activity);
    }

    @Override
    public Activity retrieve(int id) {
        return repository.get(id);
    }


    @Override
    public Activity delete(int id) {
        Activity activity = repository.get(id);
        this.repository.remove(id);
        return activity;
    }

    public ArrayList<Activity> getAllActivities() {
        return new ArrayList<Activity>(this.repository.values());
    }
}
