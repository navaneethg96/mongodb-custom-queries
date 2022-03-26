package com.example.mongodb.model;

import lombok.*;

//@Getter
//@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    private String line1;
    private String line2;
    private String city;
    private String state;
    private Integer zipCode;
}
