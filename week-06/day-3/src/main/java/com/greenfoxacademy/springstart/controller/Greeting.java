package com.greenfoxacademy.springstart.controller;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {

    private long greetCount;
    private String content;

    public Greeting(Long greetCount, String content) {
        this.greetCount = greetCount;
        this.content = content;
    }

    public long getGreetCount() {
        return greetCount;
    }

    public String getContent() {
        return content;
    }


}
