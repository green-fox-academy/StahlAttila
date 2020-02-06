package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.User;

public interface UserService {

    String registerUser(String username, String password);

    User findUserByNameAndPW(String username, String password);

    User findByName(String username);
}
