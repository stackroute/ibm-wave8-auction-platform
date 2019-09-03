package com.stackroute.auction.registrationform.service;

import com.stackroute.auction.registrationform.model.RentItems;
import com.stackroute.auction.registrationform.model.User;
import com.stackroute.auction.registrationform.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private User user;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private MongoTemplate mongoTemplate;

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

    @Override
    public User updateUser(User user) {

       User  result=getUserByEmail(user.getUserEmail());

        result.setUserName(user.getUserName());
        result.setUserEmail(user.getUserEmail());
        result.setUserPhoneNumber(user.getUserPhoneNumber());
        result=userRepository.save(user);

        return result;

    }

    @Override
    public boolean deleteUser(String email) {
       userRepository.delete(getUserByEmail(email));
       return true;
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userEmail").is(email));
        User savedUser = mongoTemplate.findOne(query, User.class);
        return savedUser;
    }
    @Override
    public User saveItems(RentItems rentItems,String email) {
        User savedUser=getUserByEmail(email);
        savedUser.setRentItems(rentItems);
        userRepository.save(savedUser);
        return savedUser;
    }
    @Override
    public List<RentItems> getAllItems(String email ) {
        List<RentItems> rentItems=new ArrayList<>();
        User savedUser=getUserByEmail(email);
        rentItems= (List<RentItems>) savedUser.getRentItems();
        return  rentItems;

    }

    @Override
    public User updateRentItems(RentItems rentItems,String email) {
      User result=getUserByEmail(email);
      result.getRentItems().setItemDurationOfRent(rentItems.getItemDurationOfRent());
      userRepository.save(result);
      return result;
    }

    @Override
    public boolean deleteItems(String email) {
        User result=getUserByEmail(email);
        result.setRentItems(null);
        userRepository.save(result);
        return true;
    }




}

