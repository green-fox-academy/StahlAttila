package com.greenfoxacademy.programmerfoxclub.Model;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class TrickList {
    private List<Trick> trickList;

    public TrickList() {
        this.trickList = new ArrayList<>();
    }

    public void addTrick(String name){
        trickList.add(new Trick(name));
    }
}
