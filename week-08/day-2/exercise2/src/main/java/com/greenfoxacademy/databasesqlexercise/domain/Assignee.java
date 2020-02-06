package com.greenfoxacademy.databasesqlexercise.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Assignee {

    @Id
    @GeneratedValue
    long id;
    private String name;
    private String email;

    @ManyToOne
    Todo todo;

    public Assignee() {
    }

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Assignee(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
