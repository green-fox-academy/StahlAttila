package com.reddit.reddit.Repository;

import com.reddit.reddit.Domain.Post;
import com.reddit.reddit.Domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "select * from post order by like_counter desc limit 10", nativeQuery = true)
    List<Post> findTopTen();
    Post findByUser(User user);
    Page<Post> findAllByUser(User user, Pageable pageable);

    @Query(value = "select * from post order by like_counter desc ", nativeQuery = true)
    Page<Post> findAllPaged(User user, Pageable pageable);
}
