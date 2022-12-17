package com.example.lab2.entities;

public class Activity {
    private int id;
    private Student student;
    private Lesson lesson;
    private boolean presence;
    private int grade;

    public Activity() {
    }

    public Activity(int id, Student student, Lesson lesson, boolean presence) {
        this.id = id;
        this.student = student;
        this.lesson = lesson;
        this.presence = presence;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Lesson getLesson() {
        return lesson;
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

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
