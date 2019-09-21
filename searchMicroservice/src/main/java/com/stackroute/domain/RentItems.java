package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentItems {

    @JsonProperty("itemid")
    private Long itemid;
    @JsonProperty("itemName")
    private String itemName;
    @JsonProperty("itemDescription")
    private String itemDescription;
    @JsonProperty("itemImageUrl")
    private String itemImageUrl;

}
