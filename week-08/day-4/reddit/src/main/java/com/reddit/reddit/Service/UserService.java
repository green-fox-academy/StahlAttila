package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.User;

import java.util.List;

public interface UserService {

    void registerUser(String username, String password);

    User findUserByNameAndPW(String username, String password);

    User findByName(String username);

    List<Integer> getPageNumber(String username);
}
