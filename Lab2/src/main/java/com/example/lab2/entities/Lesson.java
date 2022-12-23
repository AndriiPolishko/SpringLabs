package com.example.lab2.entities;

import java.time.LocalDate;

public class Lesson {
    private int id;
    private LocalDate date;

    public Lesson() {

    }
    public Lesson(int id, String date) {
        this.id = id;
        this.date = LocalDate.parse(date);
    }

    public LocalDate getDate(){
        return date;
    }

    public int getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date);
    }
    public void setId(int id) {
        this.id = id;
    }

}

