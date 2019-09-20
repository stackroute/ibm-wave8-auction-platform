package com.stackroute.springbootneo4jexample1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.neo4j.ogm.annotation.*;

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentItems {
    @Id
    @GeneratedValue
    private Long id;
    @Index
    @JsonProperty("itemid")
    private Integer itemid;
    @Id
    @JsonProperty("itemName")
    private String itemName;
    @JsonProperty("itemDescription")
    private String itemDescription;
    //private String owner;
    @JsonProperty("itemImageUrl")
    private String itemImageUrl;

    @JsonProperty("itemCategory")
    @Relationship(type = "BELONGS_TO", direction = Relationship.OUTGOING)
    private Category category;

}
