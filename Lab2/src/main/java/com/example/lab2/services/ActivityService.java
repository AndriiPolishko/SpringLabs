package com.example.lab2.services;

import com.example.lab2.entities.Activity;
import com.example.lab2.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) this.userRepository.findAll();
    }

    @Override
    public List<UserEntity> getUsersOrderedByEmail() {
        return this.userRepository.findAllOrderedByEmail();
    }

}
