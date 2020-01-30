package com.greenfoxacademy.dependencyexercises.Services;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentInterface {

    public List<String> findAll();

    public void save(String student);

    public Integer counter();

}
