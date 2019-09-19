package com.stackroute.model;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;

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
