package com.restexercise.restexercise.domain;

public class AppendA {

    private String appended;

    public AppendA(String appended) {
        this.appended = appended+"a";
    }

    public String getAppended() {
        return appended;
    }
}
