package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.Post;
import com.reddit.reddit.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    Post findByUser(User user);

    List<Post> getAll();

    Page<Post> getAllByUser(User user, Pageable pageable);

    Page<Post> findAllPaged(User user, Pageable pageable);

    void change(Long id, Integer n);

    void addPost(String title, String URL, User user);

    List<Post> findTopTen();

    Post findById(Long id);

    void updatePost(Long postId, String title, String URL, User user);
}
