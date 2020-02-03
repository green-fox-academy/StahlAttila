package com.greenfoxacademy.programmerfoxclub.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trick {

    private String name;

    public Trick(String name) {
        this.name = name;
    }
}
