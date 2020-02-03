package com.greenfoxacademy.programmerfoxclub.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Fox {
    private String name;
    private ArrayList<Trick> tricks = new ArrayList<>();
    private ArrayList<String> tricksAsString;
    private ArrayList<String> actionHistory;
    private String food;
    private String drink;
    private String pictureUrl;

    public Fox(String name) {
        this.tricksAsString = new ArrayList<>();
        this.name = name;
        this.actionHistory = new ArrayList<>();
        this.food = "Empty";
        this.drink = "Empty";
        this.pictureUrl = "greenfox.png";
    }

    public ArrayList<String> getTricksAsString() {
        return tricksAsString;
    }

    public ArrayList<Trick> getTricks(){
        return this.tricks;
    }
}
