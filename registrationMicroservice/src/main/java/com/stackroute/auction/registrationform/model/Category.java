package com.stackroute.auction.registrationform.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class Category {
        private String name;
}
