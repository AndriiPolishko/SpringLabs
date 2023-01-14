package com.example.lab5_jdbctemplate.dao;
import com.example.lab5_jdbctemplate.entity.User;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserDao implements Dao<User> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Long create(User user) {

        return 0L;
    }
    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }
    public void update(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }
    public List<User> getAll() {
        return null;
    }

}
