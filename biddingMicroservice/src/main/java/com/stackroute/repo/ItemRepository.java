package com.stackroute.repo;

import com.stackroute.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ItemRepository {

    private Item item;

    public static final String KEY = "ITEM";
    private RedisTemplate<String,Item> redisTemplate;
    private HashOperations hashOperations;

    public ItemRepository(RedisTemplate<String, Item> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    /*Getting all Items from tSable*/
    public Map<Integer,Item> getAllItems(){
        return hashOperations.entries(KEY);
    }
    /*Getting a specific item by item id from table*/
    public Item getItem(Long itemId){
        return (Item) hashOperations.get(KEY,itemId);
    }

    /*Adding an item into redis database*/
    public void addItem(Item item){
        hashOperations.put(KEY,item.getItemId(),item);
    }
    /*delete an item from database*/
    public void deleteItem(int id){
        hashOperations.delete(KEY,id);
    }

    /*update an item from database*/
    public void updateItem(Item item){
        addItem(item);
    }

    /*ArrayList of Items*/
    public ArrayList<Item> itemSorting()
    {
        Map<Integer, Item> listOfItems = this.getAllItems();

        ArrayList<Item> arrayOfItems = new ArrayList<>();
        for (Object e: listOfItems.values())
        {
            item=(Item)e;
            arrayOfItems.add(item);
        }

        Comparator<Item> sortByBiddingCounter=(Item item1, Item item2) -> item2.getBiddingCounter()-item1.getBiddingCounter();
        Collections.sort(arrayOfItems, sortByBiddingCounter);

        return arrayOfItems;
    }
}