package com.stackroute.springbootneo4jexample1.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Category {
    private String name;
    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}
