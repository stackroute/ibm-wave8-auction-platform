package com.stackroute.auction.registrationform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    //private String UserId;
    private String userEmail;
    private String userName;
    private String userPhoneNumber;
    private String userGender;
    private String userAadharNumber;
    private String userPassword;
    private RentItems rentItems;
}
