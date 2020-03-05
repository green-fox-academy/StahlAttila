package com.greenfoxacademy.projectmovieapp.services;


import com.greenfoxacademy.projectmovieapp.domains.User;

public interface UserService {

    User findByName(String name);
}
