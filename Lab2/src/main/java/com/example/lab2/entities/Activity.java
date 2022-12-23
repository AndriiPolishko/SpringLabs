package com.example.lab2.entities;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Activity {
    private int id;
    private int studentId;
    private int lessonId;
    private boolean presence;
    private int grade;

    public Activity() {
    }

    public Activity(int id, int studentId, int lessonId, boolean presence) {
        this.id = id;
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.presence = presence;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public boolean isPresence() {
        return presence;
    }

    public int getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
