package com.stackroute.auction.registrationform.service;

import com.stackroute.auction.registrationform.model.User;
import com.stackroute.auction.registrationform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)  {
            User savedUser =userRepository.save(user);
            if(savedUser == null) {
                savedUser = null;
            }
            return savedUser;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
