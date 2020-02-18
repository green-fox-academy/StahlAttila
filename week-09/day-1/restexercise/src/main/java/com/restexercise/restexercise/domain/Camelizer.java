package com.restexercise.restexercise.Domain;

public class Camelizer {

    private String text;
    private String translated;
    private String lang;

    public Camelizer() {
    }

    public Camelizer(String text, String lang) {
        this.text = text;
        this.lang = lang;
    }


}
