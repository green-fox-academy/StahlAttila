package com.reddit.reddit.Service;

import com.reddit.reddit.Domain.User;
import com.reddit.reddit.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(String username, String password) {
        if(userRepository.findByUsername(username) == null ){
            userRepository.save(new User(username, password));
            return "redirect:/login";
        }

        return "redirect:/login";
    }

    @Override
    public User findUserByNameAndPW(String username, String password) {
         return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }
}
