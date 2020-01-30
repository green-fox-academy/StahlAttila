package com.greenfoxacademy.dependencyexercises.Services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService2 implements StudentInterface {
    @Override
    public List<String> findAll() {
        return null;
    }

    @Override
    public void save(String student) {

    }

    @Override
    public Integer counter() {
        return null;
    }
}
