package com.greenfoxacademy.programmerfoxclub.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trick {

    private String name;
    private TrickDifficulty trickDif;

    public Trick(String name, TrickDifficulty trickDif) {
        this.name = name;
        this.trickDif = trickDif;
    }

    public Trick(String name) {
        this.name = name;
    }
}
