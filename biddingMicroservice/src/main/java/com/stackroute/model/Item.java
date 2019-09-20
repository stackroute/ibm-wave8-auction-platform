package com.stackroute.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

//@RedisHash("biddingItem")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {

    //item details
    private int itemId;

//    @JsonProperty("rentItems.itemName")
    private String itemName;
//    @JsonProperty("rentItems.itemDescription")
    private String itemDescription;
//    @JsonProperty("rentItems.itemCategory")
    private String itemCategory;
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

    public Item() {
    }

    public Item(int itemId, String itemName, String itemDescription, String itemCategory, int itemQuantity, int numberOfDaysForRent, double itemBaseRent, double minimumBiddingAmount, int timeLeft, double latestBid, double yourBid, int numberOfDaysNeeded, int biddingCounter, String userEmailId, String userName, String userPhoneNumber, String bidderEmailId, String biddername, long bidderPhoneNumber) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
        this.numberOfDaysForRent = numberOfDaysForRent;
        this.itemBaseRent = itemBaseRent;
        this.minimumBiddingAmount = minimumBiddingAmount;
        this.timeLeft = timeLeft;
        this.latestBid = latestBid;
        this.yourBid = yourBid;
        this.numberOfDaysNeeded = numberOfDaysNeeded;
        this.biddingCounter = biddingCounter;
        this.userEmailId = userEmailId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.bidderEmailId = bidderEmailId;
        this.biddername = biddername;
        this.bidderPhoneNumber = bidderPhoneNumber;
    }

    //item details getter and setter
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuality) {
        this.itemQuantity = itemQuantity;
    }

    public int getNumberOfDaysForRent() {
        return numberOfDaysForRent;
    }

    public void setNumberOfDaysForRent(int numberOfDaysForRent) {
        this.numberOfDaysForRent = numberOfDaysForRent;
    }

    public double getItemBaseRent() {
        return itemBaseRent;
    }

    public void setItemBaseRent(double itemBaseRent) {
        this.itemBaseRent = itemBaseRent;
    }

    //item bidding details getter and setter
    public double getMinimumBiddingAmount() {
        return minimumBiddingAmount;
    }

    public void setMinimumBiddingAmount(double minimumBiddingAmount) {
        this.minimumBiddingAmount = minimumBiddingAmount;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public double getLatestBid() {
        return latestBid;
    }

    public void setLatestBid(double latestBid) {
        this.latestBid = latestBid;
    }

    public double getYourBid() {
        return yourBid;
    }

    public void setYourBid(double yourBid) {
        this.yourBid = yourBid;
    }

    public int getNumberOfDaysNeeded() {
        return numberOfDaysNeeded;
    }

    public void setNumberOfDaysNeeded(int numberOfDaysNeeded) {
        this.numberOfDaysNeeded = numberOfDaysNeeded;
    }

    public int getBiddingCounter() {
        return biddingCounter;
    }

    public void setBiddingCounter(int biddingCounter) {
        this.biddingCounter = biddingCounter;
    }

    //rented user details getter and setter
    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    //bidding user details getter and setter
    public String getBidderEmailId() {
        return bidderEmailId;
    }

    public void setBidderEmailId(String bidderEmailId) {
        this.bidderEmailId = bidderEmailId;
    }

    public String getBiddername() {
        return biddername;
    }

    public void setBiddername(String biddername) {
        this.biddername = biddername;
    }

    public long getBidderPhoneNumber() {
        return bidderPhoneNumber;
    }

    public void setBidderPhoneNumber(long bidderPhoneNumber) {
        this.bidderPhoneNumber = bidderPhoneNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", numberOfDaysForRent=" + numberOfDaysForRent +
                ", itemBaseRent=" + itemBaseRent +
                ", minimumBiddingAmount=" + minimumBiddingAmount +
                ", timeLeft=" + timeLeft +
                ", latestBid=" + latestBid +
                ", yourBid=" + yourBid +
                ", numberOfDaysNeeded=" + numberOfDaysNeeded +
                ", userEmailId='" + userEmailId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", bidderEmailId='" + bidderEmailId + '\'' +
                ", biddername='" + biddername + '\'' +
                ", bidderPhoneNumber=" + bidderPhoneNumber +
                '}';
    }
}
