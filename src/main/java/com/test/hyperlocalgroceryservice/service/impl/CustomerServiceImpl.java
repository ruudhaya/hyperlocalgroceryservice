package com.test.hyperlocalgroceryservice.service.impl;

import com.test.hyperlocalgroceryservice.dto.CustomerRequest;
import com.test.hyperlocalgroceryservice.model.Customer;
import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.repository.CustomerRepository;
import com.test.hyperlocalgroceryservice.repository.ItemRepository;
import com.test.hyperlocalgroceryservice.service.CustomerService;
import com.test.hyperlocalgroceryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer verifyUserLogin(String email, String password) {
        Customer matchedCustomer = customerRepository.findValidCustomer(email, password);
        if (matchedCustomer != null) {
            return matchedCustomer;
        }

        return null;
    }

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(new Customer(customerRequest));
    }
}