package com.example.lab2.lesson;

import java.time.LocalDate;

public class Lesson {
    private int id;
    private LocalDate date;
    public Lesson(int id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Lesson(int id, String date) {
        this.id = id;
        this.date = LocalDate.parse(date);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

