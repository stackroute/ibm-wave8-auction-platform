package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

//@RedisHash("biddingItem")
//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    //item details
    private Long itemId;

//    @JsonProperty("rentItems.itemName")
    private String itemName;
//    @JsonProperty("rentItems.itemDescription")
    private String itemDescription;
//    @JsonProperty("rentItems.itemImageUrl")
    private String itemImageUrl;
//    @JsonProperty("rentItems.itemQuality")
    private int itemQuantity;
//    @JsonProperty("rentItems.itemDurationOfRent")
    private int numberOfDaysForRent;
//    @JsonProperty("rentItems.baseRent")
    private double itemBaseRent;

    //item bidding details
    private double minimumBiddingAmount;
    private int timeLeft;
    private double latestBid;
    private double yourBid;
    private int numberOfDaysNeeded;
    private int biddingCounter;

    //rented user details
//    @JsonProperty("userEmail")
    private String userEmailId;
//    @JsonProperty("userName")
    private String userName;
//    @JsonProperty("userPhoneNumber")
    private String userPhoneNumber;

    //bidding user details
    private String bidderEmailId;
    private String biddername;
    private long bidderPhoneNumber;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemImageUrl=" + itemImageUrl + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", numberOfDaysForRent=" + numberOfDaysForRent +
                ", itemBaseRent=" + itemBaseRent +
                ", minimumBiddingAmount=" + minimumBiddingAmount +
                ", timeLeft=" + timeLeft +
                ", latestBid=" + latestBid +
                ", yourBid=" + yourBid +
                ", numberOfDaysNeeded=" + numberOfDaysNeeded +
                ", biddingCounter=" + biddingCounter +
                ", userEmailId='" + userEmailId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", bidderEmailId='" + bidderEmailId + '\'' +
                ", biddername='" + biddername + '\'' +
                ", bidderPhoneNumber=" + bidderPhoneNumber +
                '}';
    }
}
