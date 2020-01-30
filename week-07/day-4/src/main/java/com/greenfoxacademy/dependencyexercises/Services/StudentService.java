package com.greenfoxacademy.dependencyexercises.Services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class StudentService implements StudentInterface {
    ArrayList<String> names;


    public StudentService() {
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    public List<String> findAll() {
        return names;
    }

    public void save(String student) {
        names.add(student);
    }

    public Integer counter(){
        return names.size();
    }
}