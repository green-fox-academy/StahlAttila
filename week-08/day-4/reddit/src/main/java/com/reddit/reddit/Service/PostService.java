package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.Post;
import com.reddit.reddit.Domain.User;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    List<Post> getAllByUser(User user);

    void change(Long id, Integer n);

    void addPost(String title, String URL, User user);

    List<Post> findTopTen();
}
