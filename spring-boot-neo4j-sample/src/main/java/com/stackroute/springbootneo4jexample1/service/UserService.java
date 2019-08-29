package com.stackroute.springbootneo4jexample1.service;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.Product;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }
    public Collection<Product> getAllProdcts() { return userRepository.getAllProducts(); }
    public Collection<Product> getAllRecm() { return userRepository.getAllRecommendProducts(); }
    public Collection<Category> getAllLikes(){ return userRepository.getAllLikes();}
}
