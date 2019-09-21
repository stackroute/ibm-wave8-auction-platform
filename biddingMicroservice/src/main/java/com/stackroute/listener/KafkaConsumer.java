package com.stackroute.listener;


import com.stackroute.model.Item;
import com.stackroute.model.RentItems;
import com.stackroute.model.User;
import com.stackroute.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class KafkaConsumer  {

//    @Autowired
//    private ItemDao itemDao;

    @Autowired
    private ItemRepository itemRepository;

    @KafkaListener(topics = "ea-kafka-bidding", groupId = "group_id")
    public void consume(User user) throws IOException {
//        System.out.println(item);
//        Item obj = new ObjectMapper().readValue(daoUser, Item.class);

//        obj.setPassword(bcryptEncoder.encode(obj.getPassword()));

        Item item = new Item();
        ArrayList<RentItems> rentItem=user.getRentItems();
        RentItems userItems=rentItem.get(0);

            item.setItemId(userItems.getItemid());
            item.setItemName(userItems.getItemName());
             item.setItemImageUrl(userItems.getItemImageUrl());
            item.setItemDescription(userItems.getItemDescription());
            item.setItemQuantity(userItems.getItemQuantity());
            item.setNumberOfDaysForRent(userItems.getItemDurationOfRent());
            item.setItemBaseRent(userItems.getBaseRent());

        //set values to item entity

        //rented user details
        item.setUserEmailId(user.getUserEmail());
        item.setUserName(user.getUserName());
        item.setUserPhoneNumber(user.getUserPhoneNumber());

//        addToReddis(user,rentItem);

        System.out.println(" item :"+ item.toString());

        itemRepository.addItem(item);
    }
//     void addToReddis(User user, RentItems userItems){
//
//        Item item=new Item();
//         //item details
//
//
//         item.setMinimumBiddingAmount(0.0);
//         item.setTimeLeft(0);
//         item.setLatestBid(0.0);
//         item.setYourBid(0.0);
//         item.setNumberOfDaysNeeded(0);
//
//         item.setBidderEmailId(null);
//         item.setBiddername(null);
//         item.setBidderPhoneNumber(0);
//
//    }
}
