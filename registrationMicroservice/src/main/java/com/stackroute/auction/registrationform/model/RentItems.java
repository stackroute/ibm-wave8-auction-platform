package com.stackroute.auction.registrationform.model;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class RentItems {
    @Transient
    public static final String SEQUENCE_NAME="rentItems_sequence";
    @Id
    private Long itemid;
    private String itemName;
    private Category itemCategory;
    private int itemQuantity;
    private String itemDescription;
    private int itemDurationOfRent;
    private int baseRent;
    private String itemImageUrl;
}


