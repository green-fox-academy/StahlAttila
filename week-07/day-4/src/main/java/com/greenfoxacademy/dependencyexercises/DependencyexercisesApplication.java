package com.greenfoxacademy.dependencyexercises;

import com.greenfoxacademy.dependencyexercises.Model.BlueColor;
import com.greenfoxacademy.dependencyexercises.Model.MyColor;
import com.greenfoxacademy.dependencyexercises.Model.Printer;
import com.greenfoxacademy.dependencyexercises.Model.RedColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DependencyexercisesApplication implements CommandLineRunner {
    Printer printer;

    @Autowired
    public DependencyexercisesApplication(MyColor color, Printer printer) {
        this.printer = printer;
    }


    public static void main(String[] args) {
        SpringApplication.run(DependencyexercisesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log();
    }
}
