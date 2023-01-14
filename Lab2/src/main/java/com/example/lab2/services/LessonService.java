package com.example.lab2.services;

import com.example.lab2.entities.Lesson;
import com.example.lab2.repositories.LessonRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LessonService {
    private final LessonRepository LessonRepository;

    public Optional<Lesson> getUserById(Long id) {
        return this.LessonRepository.findById(id);
    }

    public List<Lesson> getUsers() {
        return (List<Lesson>) this.LessonRepository.findAll();
    }

    public List<Lesson> getUsersOrderedByEmail() {
        return this.LessonRepository.findAllOrderedByEmail();
    }
}
