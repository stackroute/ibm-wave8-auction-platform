package com.stackroute.springbootneo4jexample1.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity
public class WishlistProduct {
    @Id
    //@GraphId
    private Long itemid;
    private String itemName;
    private String itemDescription;
    //private String owner;

    public WishlistProduct() {
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
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
}
