package com.greenfoxacademy.databasesqlexercise.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    Boolean urgent;
    Boolean done;

    @OneToMany(mappedBy = "todo")
    List<Assignee> assignees;

    public Todo() {
    }

    public Todo(Long id, String title, Boolean urgent, Boolean done) {
        this.id = id;
        this.title = title;
        this.urgent = urgent;
        this.done = done;
    }

    public Todo(Long id, String title) {
        this.id = id;
        this.title = title;
        this.urgent = false;
        this.done = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getUrgent() {
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
