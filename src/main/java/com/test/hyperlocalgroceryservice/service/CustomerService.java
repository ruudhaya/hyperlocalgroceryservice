package com.test.hyperlocalgroceryservice.service;

import com.test.hyperlocalgroceryservice.dto.CustomerRequest;
import com.test.hyperlocalgroceryservice.model.Customer;

public interface CustomerService {
    Customer verifyUserLogin(String email, String password);

    Customer createCustomer(CustomerRequest customer);
}
