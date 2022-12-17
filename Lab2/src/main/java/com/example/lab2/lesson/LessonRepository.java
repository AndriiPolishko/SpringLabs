package com.example.lab2.lesson;

import java.util.HashMap;
import java.util.Map;

import com.example.lab2.repositories.ObjectRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LessonRepository implements ObjectRepository<Lesson> {

    private Map<Integer, Lesson> repository;

    public LessonRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void store(Lesson lesson) {
        repository.put(lesson.getId(), lesson);
    }

    @Override
    public Lesson retrieve(int id) {
        return repository.get(id);
    }


    @Override
    public Lesson delete(int id) {
        Lesson e = repository.get(id);
        this.repository.remove(id);
        return e;
    }

}