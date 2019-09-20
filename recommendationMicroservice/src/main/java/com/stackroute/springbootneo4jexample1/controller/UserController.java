package com.stackroute.springbootneo4jexample1.controller;

import com.stackroute.springbootneo4jexample1.model.Category;
import com.stackroute.springbootneo4jexample1.model.RentItems;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.model.WishlistProduct;
import com.stackroute.springbootneo4jexample1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/userrcm/{email}")
    public Collection<RentItems> getAllRec(@PathVariable(name = "email") String email) {
        return userService.getAllRecm(email);
    }

    @GetMapping("/wishlistproducts/{email}")
    public Collection<RentItems> getMyFavProducts(@PathVariable(name = "email") String email){ return userService.getMyFavs(email); }

    @PostMapping("/savewishlist/{email}/{itemName}/{itemDescription}")
    public ResponseEntity<RentItems> saveWishlist(@PathVariable(name = "email") String email,@PathVariable(name = "itemName") String itemName,@PathVariable(name = "itemDescription") String itemDescription){

        ResponseEntity responseEntity;
        userService.saveMyFav(email, itemName, itemDescription);
        responseEntity=new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/removefav/{email}/{name}")
    public ResponseEntity<?> deleteTrackByname(@PathVariable(name = "email") String email,@PathVariable(name = "name") String name)  {
       Collection<RentItems> wishlist;
        wishlist = userService.deleteWLProductByName(email, name);
        return new ResponseEntity(wishlist, HttpStatus.OK);
    }
}
