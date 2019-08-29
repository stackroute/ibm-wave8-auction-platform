package com.stackroute.auction.registrationform.model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    private String userPhoneNumber;
    private String userGender;
    private String userAadharNumber;
    private String userEmail;
    private String userPassword;
    private String category;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private RentItems rentItems;
}
