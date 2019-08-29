package com.stackroute.springbootneo4jexample1.controller;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.Product;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public Collection<User> getAll() {
        return userService.getAll();
    }


    @GetMapping("/userslikes")
    public Collection<Category> getAllLikes() {
        return userService.getAllLikes();
    }
    @GetMapping("/userrcm")
    public Collection<Product> getAllRec() {
        return userService.getAllRecm();
    }
}
