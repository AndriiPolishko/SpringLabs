package com.example.lab2.repositories;

import com.example.lab2.entities.Activity;

import java.util.Map;

public interface ObjectRepository<T> {
    public void store(T t);

    public T retrieve(int id);

    public T delete(int id);

}