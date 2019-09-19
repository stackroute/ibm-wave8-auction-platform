package com.stackroute.service;


import com.stackroute.domain.Items;
import com.stackroute.domain.RentItems;
import com.stackroute.domain.User;
import com.stackroute.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

public  User saveUser(User user);
public List<User> getAllUsers();
   public List<User> getProductByName(String name) throws ProductNotFoundException;
}
