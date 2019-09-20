package com.stackroute.controller;

import com.stackroute.model.Item;
import com.stackroute.model.User;
import com.stackroute.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

//    @Autowired
//    private org.springframework.kafka.core.KafkaTemplate<String, User> KafkaTemplate;
//
//    private static final String TOPIC="kafkaExample6";

    @Autowired
    private ItemRepository itemRepo;

    private Item item1;

    @GetMapping("/getAllItems")
    @ResponseBody
    public ResponseEntity<Map<Integer,Item>> getAllItems(){
        Map<Integer,Item> items =  itemRepo.getAllItems();
        return new ResponseEntity<Map<Integer,Item>>(items, HttpStatus.OK);
    }

    @GetMapping("/item/{itemId}")
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable int itemId){
        Item item = itemRepo.getItem(itemId);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PostMapping(value = "/addItem",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Item> addItem(@RequestBody Item item,UriComponentsBuilder builder){
        itemRepo.addItem(item);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addItem/{id}").buildAndExpand(item.getItemId()).toUri());
        return new ResponseEntity<Item>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/updateItem/{itemId}/{itemCurrentBid}/{noOfDaysNeeded}/{bidderName}/{bidderEmailId}/{bidderPhoneNumber}")
    @ResponseBody
    public ResponseEntity<Item> updateItem(@PathVariable int itemId, @PathVariable double itemCurrentBid, @PathVariable int noOfDaysNeeded, @PathVariable String bidderName, @PathVariable String bidderEmailId, @PathVariable long bidderPhoneNumber){
        Item item=itemRepo.getItem(itemId);
        if(item != null){
//            double itemMinBid=item.getMinimumBiddingAmount()+100;

            double itemLatestBid=item.getLatestBid();
            int duration=item.getNumberOfDaysNeeded();
            int counter=item.getBiddingCounter();
//            if(noOfDaysNeeded<=duration && itemCurrentBid >= itemLatestBid+100)
//            {
//                item.setNumberOfDaysNeeded(noOfDaysNeeded);
//                item.setLatestBid(itemCurrentBid);
//                item.setMinimumBiddingAmount(item.getLatestBid()+100);
//                item.setYourBid(itemCurrentBid);
//            }

            if(itemCurrentBid > itemLatestBid)
            {
                if(noOfDaysNeeded<=duration)
                {
                    if(itemCurrentBid*noOfDaysNeeded>itemLatestBid*duration)
                    {
                        item.setNumberOfDaysNeeded(noOfDaysNeeded);
                        item.setLatestBid(itemCurrentBid);
                        item.setBiddingCounter(counter+1);
                        //bidder details
                        item.setBiddername(bidderName);
                        item.setBidderEmailId(bidderEmailId);
                        item.setBidderPhoneNumber(bidderPhoneNumber);
                    }
                }
                else
                {
                    item.setNumberOfDaysNeeded(noOfDaysNeeded);
                    item.setLatestBid(itemCurrentBid);
                    item.setBiddingCounter(counter+1);
                    //bidder details
                    item.setBiddername(bidderName);
                    item.setBidderEmailId(bidderEmailId);
                    item.setBidderPhoneNumber(bidderPhoneNumber);
                }
            }

            itemRepo.updateItem(item);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    @ResponseBody
//    public ResponseEntity<Void> deleteItem(@PathVariable int id){
//        itemRepo.deleteItem(id);
//        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//    }

    @RequestMapping("/trending")
    public ResponseEntity<ArrayList<Item>> trendingItems()
    {
        ArrayList<Item> arrayOfItems=itemRepo.itemSorting();

        ArrayList<Item> subArrayListOfItem = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            subArrayListOfItem.add(arrayOfItems.get(i));
        }
        return new ResponseEntity<ArrayList<Item>>( subArrayListOfItem, HttpStatus.OK);
    }

    @RequestMapping("/newlyAdded")
    public ResponseEntity<ArrayList<Item>> newlyAddedItem()
    {
        ArrayList<Item> arrayOfItems=itemRepo.itemSorting();

        ArrayList<Item> subArrayListOfItem = new ArrayList<>();
        for(int i=arrayOfItems.size()-1;i>arrayOfItems.size()-4;i--)
        {
            subArrayListOfItem.add(arrayOfItems.get(i));
        }
        return new ResponseEntity<ArrayList<Item>>( subArrayListOfItem, HttpStatus.OK);
    }
}
