package com.greenfoxacademy.dependencyexercises.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Printer {

    MyColor color;

    @Autowired
    public Printer(MyColor color) {
        this.color = color;
    }

    public void log() {
        color.printColor();
    }
}
