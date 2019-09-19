package com.stackroute.springbootneo4jexample1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @JsonProperty("userEmail")
     private String userEmail;
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("category")
    @Relationship(type = "LIKES", direction = Relationship.OUTGOING)
    private List<Category> category;

    @JsonProperty("rentItems")
    @Relationship(type = "ADDED", direction = Relationship.OUTGOING)
    private List<RentItems> rentItems;

    @Relationship(type = "INTERESTED_IN", direction = Relationship.OUTGOING)
    private List<RentItems> wishlistProducts;

}
