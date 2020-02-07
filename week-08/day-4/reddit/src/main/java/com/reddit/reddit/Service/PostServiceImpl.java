package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.Post;
import com.reddit.reddit.Domain.User;
import com.reddit.reddit.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findByUser(User user) {
        return postRepository.findByUser(user);
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Page<Post> getAllByUser(User user, Pageable pageable) {
        return postRepository.findAllByUser(user, pageable);
    }

    @Override
    public Page<Post> findAllPaged(User user, Pageable pageable) {
        return postRepository.findAllPaged(user, pageable);
    }

    @Override
    public void change(Long id, Integer n) {
        Optional<Post> postToChange = postRepository.findById(id);

        if (postToChange.isPresent()) {
            postToChange.get().setLikeCounter(n);
            postRepository.save(postToChange.get());
        }
    }

    @Override
    public void addPost(String title, String URL, User user) {
        postRepository.save(new Post(title, URL, user));
    }

    @Override
    public List<Post> findTopTen() {
        return postRepository.findTopTen();
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> postById = postRepository.findById(id);

        return postById.orElse(null);
    }

    @Override
    public void updatePost(Long postId, String title, String URL, User user) {
        postRepository.save(new Post(postId, title, URL, user));
    }

}
