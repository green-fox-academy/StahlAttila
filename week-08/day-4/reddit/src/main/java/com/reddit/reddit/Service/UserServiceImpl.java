package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.User;
import com.reddit.reddit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(String username, String password) {
            userRepository.save(new User(username, password));
    }

    @Override
    public User findUserByNameAndPW(String username, String password) {
         return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<Integer> getPageNumber(String username) {
        List<Integer> numberOfLinks = new ArrayList<>();
        for (int i = 0; i < (userRepository.findByUsername(username).getPosts().size()/10)+1;  i++) {
            numberOfLinks.add(i);
        }
        return numberOfLinks;
    }
}
