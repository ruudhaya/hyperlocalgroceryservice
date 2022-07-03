package com.test.hyperlocalgroceryservice.model;

import com.test.hyperlocalgroceryservice.dto.CustomerRequest;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    public Customer(){}

    public Customer(CustomerRequest customerRequest) {
        email = customerRequest.getEmail();
        password = customerRequest.getPassword();
        firstname = customerRequest.getFirstname();
        lastname = customerRequest.getLastname();
    }
}
