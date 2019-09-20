package com.stackroute.listener;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.domain.User;
import com.stackroute.repository.ProductRepository;
import com.stackroute.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class KafkaConsumer {
    @Autowired
    ProductRepository productRepository;

    @KafkaListener(topics = "kafka-Example4", groupId = "group_id4")
    public void consume(User user) throws IOException {
        System.out.println(user);

       //User obj = new ObjectMapper().readValue(user, User.class);
        productRepository.save(user);
//        productRepository.save(obj);
    }
}