package com.stackroute.springbootneo4jexample1.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.springbootneo4jexample1.model.User;
import com.stackroute.springbootneo4jexample1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class KafkaConsumer {
    @Autowired
    UserRepository userRepository;
//       @KafkaListener(topics = "kafka-Example4")
    @KafkaListener(topics = "kafka-Example4", groupId = "group_id")
    public void consume(User user) throws IOException {
        System.out.println(user);
     // User obj = new ObjectMapper().readValue(user, User.class);
        System.out.println(userRepository.save(user));
    }
}

