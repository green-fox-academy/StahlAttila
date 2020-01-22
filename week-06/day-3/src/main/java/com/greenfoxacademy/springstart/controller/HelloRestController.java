package com.greenfoxacademy.springstart.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRestController {

    private AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting")
    public Greeting greeting(@RequestParam String name){
        long greetCount = counter.get()+1;
        counter.incrementAndGet();
        return new Greeting(greetCount, "hello, " + name);
    }
}
