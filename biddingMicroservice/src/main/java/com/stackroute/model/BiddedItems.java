package com.stackroute.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BiddedItems {
    @Id
    private Long itemid;
    private String itemName;
    private String itemCategory;
    private int itemQuantity;
    private String itemDescription;
    private int itemDurationOfRent;
    private int baseRent;
    private String ownerName;
    private String ownerEmail;
    private int biddedRent;
}
