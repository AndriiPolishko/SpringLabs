package com.example.lab2.student;

import com.example.lab2.lesson.Lesson;

import java.util.Map;

public class Student {
    private int id;
    private String name;
    private Map<Lesson, Integer> grades;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Lesson, Integer> getGrades() {
        return grades;
    }

    public void setGrade(Lesson lesson, int grade) {
        grades.put(lesson,grade);
    }

    public int getGrade(Lesson lesson) {
        return grades.get(lesson);
    }

}
