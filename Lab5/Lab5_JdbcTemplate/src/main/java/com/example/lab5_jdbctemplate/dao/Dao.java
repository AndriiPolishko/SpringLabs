package com.example.lab5_jdbctemplate.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Long deleteById(Long id);
    void update(T t);
    List<T> getAll();
    Long create(T t);

    Optional<T> getById(Long id);
}
