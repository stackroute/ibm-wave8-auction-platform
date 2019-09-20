package com.stackroute.service;

import com.stackroute.domain.Items;
import com.stackroute.domain.RentItems;
import com.stackroute.domain.User;
import com.stackroute.exception.ProductNotFoundException;
import com.stackroute.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    @Override
    public User saveUser(User user) {
        return productRepository.save(user);
    }


    @Override
    public List<User> getAllUsers() {
        return productRepository.findAll();
    }


    @Override
        public List<User> getProductByName (String name) throws ProductNotFoundException {
            List<User> user = productRepository.getProductByName(name);
//            List<Items> items=null;
            for(int i=0; i< user.size(); i++) {
                System.out.println(user.get(i).getRentItems());
            }
            System.out.println(user);
            if (user.isEmpty()) {
                throw new ProductNotFoundException("Product not found");
            }
//            return product;
            return user;
        }
    }

