package com.greenfoxacademy.dependencyexercises.Model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class RedColor implements MyColor {
    @Override
    public void printColor() {
        System.out.println("It's red!");
    }
}
