package com.restexercise.restexercise.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Greeter {

    private String name;
    private String title;
    private String welcome_message;
    private String error;

    public Greeter(String name, String title) {
        if(name == null && title == null){
            this.error = "Please provide a name and a title!";
        }else if(title == null){
            this.error = "Please provide a title!";
        }else if( name != null && title != null){
            this.welcome_message = "Oh, hi there "+name+", my dear "+title+"!";
        }
    }

    public String getError() {
        return error;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWelcome_message() {
        return welcome_message;
    }

    public void setWelcome_message(String welcome_message) {
        this.welcome_message = welcome_message;
    }
}
