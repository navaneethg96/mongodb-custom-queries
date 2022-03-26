package com.example.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Document(value = "employee")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Float salary;

    public Employee(String firstName, String lastName, Address address, Float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.salary = salary;
    }
}
