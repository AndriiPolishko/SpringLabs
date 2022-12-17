package com.example.lab2.repositories;

public interface ObjectRepository<T> {

    public void store(T t);

    public T retrieve(int id);

    public T delete(int id);
}