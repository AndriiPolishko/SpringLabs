package com.example.lab2.repositories;

import com.example.lab2.entities.Activity;

import java.util.Map;

public interface ObjectRepository<T> {
     void store(T t);

     T retrieve(int id);

     T delete(int id);

}