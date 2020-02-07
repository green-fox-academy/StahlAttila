package com.reddit.reddit.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue
    long id;
    String title;
    String URL;
    Integer likeCounter;

    @Temporal(TemporalType.DATE)
    Date date;

    @ManyToOne
    User user;

    public Post() {
    }

    public Post(String title, String URL, User user) {
        this.title = title;
        this.URL = URL;
        this.likeCounter = 0;
        this.date = new Date();
        this.user = user;

    }

    public Post(Long id, String title, String URL, User user) {
        this.id = id;
        this.title = title;
        this.URL = URL;
        this.likeCounter = 0;
        this.date = new Date();
        this.user = user;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(Integer n) {
        this.likeCounter += n;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
