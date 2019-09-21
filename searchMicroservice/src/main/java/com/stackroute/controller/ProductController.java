package com.stackroute.controller;


import com.stackroute.domain.RentItems;
import com.stackroute.domain.User;
import com.stackroute.exception.ProductNotFoundException;
import com.stackroute.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping(value="api/v1")
@CrossOrigin("*")
public class ProductController {
    private ProductService productService;
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    /*}
    //In order to search a product by its Id
    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id){
        ResponseEntity responseEntity;
        User product;
        try {
            product = productService.getProductById(id);
            responseEntity=new ResponseEntity<User>(product, HttpStatus.OK);
        } catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
        }
            return responseEntity;
    }
*/
    @PostMapping("/saveuser")
    public ResponseEntity<User> saveUser(@RequestBody User wish){

        ResponseEntity responseEntity;
        productService.saveUser(wish);
        responseEntity=new ResponseEntity("Succesfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity getAllUsers(ModelMap model)
    {
        ResponseEntity responseEntity;
        List<User> userList = productService.getAllUsers();
        responseEntity = new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        return responseEntity;
    }

//In order to search a product by its name
    @GetMapping("item/{itemName}")
    public ResponseEntity<?> getProductByName(@PathVariable String itemName) {
        ResponseEntity responseEntity;
        try {
            List<User> product = productService.getProductByName(itemName);
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        } catch (ProductNotFoundException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}

