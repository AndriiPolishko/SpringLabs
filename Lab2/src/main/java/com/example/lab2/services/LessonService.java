package com.example.lab2.services;

import com.example.lab2.entities.Lesson;
import com.example.lab2.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private static final LessonRepository lessonRepository = new LessonRepository();

    public void addLesson(Lesson lesson) {
        lessonRepository.store(lesson);
    }

    public void deleteLesson(Lesson lesson) {
        lessonRepository.delete(lesson.getId());
    }
}
