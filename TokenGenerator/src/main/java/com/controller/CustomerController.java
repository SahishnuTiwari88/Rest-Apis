package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Customer;
import com.model.CustomerDTO;
import com.service.CustomerService;

@RestController
//@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> onboardCustomer(@RequestBody CustomerDTO customerDTO) {
        // Extract necessary data from the request body
        String mobileNumber = customerDTO.getMobileNumber();
        String primaryAccount = customerDTO.getPrimaryAccount();

        Customer customer = customerService.onboardCustomer(mobileNumber, primaryAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    
}