package com.test.hyperlocalgroceryservice.controller;

import com.test.hyperlocalgroceryservice.dto.CustomerRequest;
import com.test.hyperlocalgroceryservice.model.Customer;
import com.test.hyperlocalgroceryservice.model.Item;
import com.test.hyperlocalgroceryservice.service.CustomerService;
import com.test.hyperlocalgroceryservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam String email, @RequestParam String password) {
        Customer validCustomer = customerService.verifyUserLogin(email, password);
        if (validCustomer != null)
            return ResponseEntity.status(HttpStatus.OK).body(validCustomer);
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Need permission to visit this page");
    }

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity signup(@RequestBody CustomerRequest customerRequest) {
        Customer customerCreated = customerService.createCustomer(customerRequest);
        if (customerCreated != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}