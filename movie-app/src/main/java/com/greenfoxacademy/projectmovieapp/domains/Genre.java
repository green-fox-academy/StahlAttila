package com.greenfoxacademy.projectmovieapp.domains;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genre {


    private String name;

    public Genre() {
    }

    public Genre(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}