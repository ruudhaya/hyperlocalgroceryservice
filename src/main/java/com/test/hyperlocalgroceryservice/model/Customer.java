package com.test.hyperlocalgroceryservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    private @Id Long id;
    private String email;
    private String firstName;
    private String lastName;
}
