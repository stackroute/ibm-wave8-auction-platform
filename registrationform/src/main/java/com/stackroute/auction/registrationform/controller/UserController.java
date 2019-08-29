package com.stackroute.auction.registrationform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.auction.registrationform.exception.UserAlreadyExistsException;
import com.stackroute.auction.registrationform.model.User;
import com.stackroute.auction.registrationform.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private KafkaTemplate<Object, String> KafkaTemplate;

    private static final String TOPIC="kafka-Example4";

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user) throws JsonProcessingException , UserAlreadyExistsException {
        ResponseEntity responseEntity;
        System.out.println(user);
        userService.saveUser(user);
       this.KafkaTemplate.send(TOPIC,new ObjectMapper().writeValueAsString(user));
       Map<Object,Object> model=new HashMap<>();
       model.put("message","User registered successfully");
       return ok(model);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers(ModelMap model)
    {
        ResponseEntity responseEntity;
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        responseEntity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        return responseEntity;
    }

}
