package com.stackroute.auction.registrationform.service;

import com.stackroute.auction.registrationform.model.User;

import java.util.List;


public interface  UserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
}
