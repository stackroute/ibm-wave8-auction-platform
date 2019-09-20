package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {



    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("rentItems")
    private ArrayList<RentItems> rentItems;


}
