package com.stackroute.auction.registrationform.service;

import com.stackroute.auction.registrationform.model.RentItems;
import com.stackroute.auction.registrationform.model.User;


import java.util.ArrayList;
import java.util.List;


public interface  UserService {
     User saveUser(User user);
     List<User> getAllUsers();
     User updateUser(User user);
     boolean deleteUser(String email);
     User getUserByEmail(String email);
     User saveItems(RentItems rentItems, String email);
     List<RentItems> getAllItems(String email);
     User updateRentItems(RentItems rentItems,String email,Long itemId);
     boolean deleteItems(String email,Long itemId);
}
