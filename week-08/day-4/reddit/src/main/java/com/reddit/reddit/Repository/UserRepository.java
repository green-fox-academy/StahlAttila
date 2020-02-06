package com.reddit.reddit.Repository;

import com.reddit.reddit.Domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}
