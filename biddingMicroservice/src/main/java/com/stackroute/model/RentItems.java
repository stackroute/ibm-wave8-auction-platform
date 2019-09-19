package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentItems {
    @Transient
    public static final String SEQUENCE_NAME="rentItems_sequence";
    @Id
    private Long itemid;
    private String itemName;
    private String itemImageUrl;
    private Category itemCategory;
    private int itemQuantity;
    private String itemDescription;
    private int itemDurationOfRent;
    private int baseRent;
}


