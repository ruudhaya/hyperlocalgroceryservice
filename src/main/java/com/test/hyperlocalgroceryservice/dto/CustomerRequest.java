package com.test.hyperlocalgroceryservice.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
