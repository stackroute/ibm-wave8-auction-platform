package com.stackroute.auction.registrationform.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
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
    private List<Category> category;
    private ArrayList<RentItems> rentItems;
    private ArrayList<BiddedItems> biddedItems;
}
