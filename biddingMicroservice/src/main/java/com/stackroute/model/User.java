package com.stackroute.model;

//import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
//@Document(collection = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    //private String UserId;
    private String userEmail;
    private String userName;
    private String userPhoneNumber;

    private ArrayList<RentItems> rentItems;
    private ArrayList<BiddedItems> biddedItems;
    public User() {
    }

    public User(String userEmail, String userName, String userPhoneNumber, String userGender, String userAadharNumber, String userPassword, ArrayList<RentItems> rentItems, ArrayList<BiddedItems> biddedItems) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.rentItems = rentItems;
        this.biddedItems = biddedItems;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public ArrayList<RentItems> getRentItems() {
        return rentItems;
    }

    public void setRentItems(ArrayList<RentItems> rentItems) {
        this.rentItems = rentItems;
    }

    public ArrayList<BiddedItems> getBiddedItems() {
        return biddedItems;
    }

    public void setBiddedItems(ArrayList<BiddedItems> biddedItems) {
        this.biddedItems = biddedItems;
    }

    @Override
    public String toString() {
        return "User{" +
                "userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", rentItems=" + rentItems +
                ", biddedItems=" + biddedItems +
                '}';
    }
}
