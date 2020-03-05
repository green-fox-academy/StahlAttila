package com.greenfoxacademy.projectmovieapp.services;

import com.greenfoxacademy.projectmovieapp.domains.User;
import com.greenfoxacademy.projectmovieapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByName(String name) {
        return repository.findById(name).orElse(null);
    }
}
