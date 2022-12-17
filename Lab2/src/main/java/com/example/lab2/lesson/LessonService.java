package com.example.lab2.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    LessonRepository lessonRepository;

    public void addLesson(Lesson lesson) {
        lessonRepository.store(lesson);
    }

    public void deleteLesson(Lesson lesson) {
        lessonRepository.delete(lesson.getId());
    }
}
