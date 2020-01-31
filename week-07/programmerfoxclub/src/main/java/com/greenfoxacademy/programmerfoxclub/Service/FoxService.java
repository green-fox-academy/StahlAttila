package com.greenfoxacademy.programmerfoxclub.Service;

import com.greenfoxacademy.programmerfoxclub.Model.Fox;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoxService {

    public void addFox(String name);

    public Fox findFox(String name);

    public Boolean isNewFox(String name);

    public List<Fox> foxList();

    void addTrick(Fox fox, String trickName);
}
