package com.stackroute.springbootneo4jexample1.service;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.RentItems;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.model.WishlistProduct;
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
    public Collection<RentItems> getAllProdcts() { return userRepository.getAllProducts(); }
    public Collection<RentItems> getAllRecm(String email) { return userRepository.getAllRecommendProducts(email); }
    public Collection<Category> getAllLikes(){ return userRepository.getAllLikes();}
    public  Collection<RentItems> getMyFavs(String email){ return userRepository.getMyFavs(email);}
    public RentItems saveMyFav(String email, String itemName, String itemDescription){
        RentItems savedFav=userRepository.saveMyFav(email,itemName,itemDescription);
        return savedFav;
    }
//
//    public User saveUser(User user){
//        User savedUser=userRepository.save(user);
//        return savedUser;
//    }

    public Collection<RentItems> deleteWLProductByName(String email,String name){

         userRepository.deleteWLProductByName(email,name);


      //  return  userRepository.getMyFavs();
        return  null;
    }


}
