package com.greenfoxacademy.programmerfoxclub.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Fox {
    private String name;
    private ArrayList<String> tricks;
    private String food;
    private String drink;

    public Fox(String name) {
        this.name = name;
        this.tricks = new ArrayList<>();
        this.food = "Empty";
        this.drink = "Empty";
    }
}
