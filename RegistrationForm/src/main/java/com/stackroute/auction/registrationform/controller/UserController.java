package com.stackroute.auction.registrationform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.auction.registrationform.exception.UserAlreadyExistsException;
import com.stackroute.auction.registrationform.model.RentItems;
import com.stackroute.auction.registrationform.model.User;
import com.stackroute.auction.registrationform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.ResponseEntity.ok;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private KafkaTemplate<Object, String> KafkaTemplate;

    private static final String TOPIC="kafka-Example3";

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
    @PostMapping("/rentItems/{email}/{id}")
    public ResponseEntity addRentItemsa(@RequestBody RentItems rentItems, @PathVariable(name = "email") String email) throws JsonProcessingException {
        ResponseEntity responseEntity;
        userService.saveItems(rentItems, email);
       this.KafkaTemplate.send(TOPIC,new ObjectMapper().writeValueAsString(rentItems));
        Map<Object,Object> model=new HashMap<>();
        model.put("message","User items are added  successfully");
        return ok(model);
        /*responseEntity = new ResponseEntity<String>("Succesfully xyzz", HttpStatus.OK);
        return responseEntity;*/


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
   @GetMapping("/getRentItems/{email}")
    public ResponseEntity getAllItems(@PathVariable(name = "email") String email,ModelMap model)
   {
       ResponseEntity responseEntity;
       List<RentItems> rentItems=userService.getAllItems(email);
       model.addAttribute("rentItems", rentItems);
       responseEntity = new ResponseEntity<List<RentItems>>( rentItems, HttpStatus.OK);
       return responseEntity;
   }

    @PutMapping("update")
    public ResponseEntity updateUsers(@RequestBody User user) throws JsonProcessingException {
        ResponseEntity responseEntity;
           userService.updateUser(user);
           this.KafkaTemplate.send(TOPIC,new ObjectMapper().writeValueAsString(user));
           Map<Object,Object> model=new HashMap<>();
           model.put("message","User details updated successfully");
           return ok(model);
    }
    @PutMapping("/updateRentItems/{email}/{id}")
    public ResponseEntity updateRentItems(@PathVariable(name = "email") String email,@RequestBody RentItems rentItems,@PathVariable(name = "id") Long id) throws JsonProcessingException {
        ResponseEntity responseEntity;
        userService.updateRentItems(rentItems, email,id);
        this.KafkaTemplate.send(TOPIC,new ObjectMapper().writeValueAsString(rentItems));
        Map<Object,Object> model=new HashMap<>();
        model.put("message","Rent details updated successfully");
        return ok(model);
    }
    @DeleteMapping("/delete/{email}")
    public ResponseEntity deleteUser(@PathVariable(name = "email") String email)
    {
        ResponseEntity responseEntity;
        userService.deleteUser(email);
        responseEntity = new ResponseEntity<String>("Succesfully Deleted", HttpStatus.OK);
        return responseEntity;

    }

    @DeleteMapping("/deleteRentItems/{email}/{id}")
    public ResponseEntity deleteUserRent(@PathVariable(name = "email") String email ,@PathVariable(name = "id") Long id)
    {
        ResponseEntity responseEntity;
        userService.deleteItems(email,id);
        responseEntity = new ResponseEntity<String>("Succesfully Deleted", HttpStatus.OK);
        return responseEntity;
    }

}
