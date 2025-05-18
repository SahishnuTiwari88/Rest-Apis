package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dao.CustomerRepository;
import com.model.Customer;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer onboardCustomer(String mobileNumber, String primaryAccount) {
        Customer customer = new Customer();
        customer.setMobileNumber(mobileNumber);
        customer.setPrimaryAccount(primaryAccount);
        // Set any other fields as required
        return customerRepository.save(customer);
    }

    // Other methods for customer-related operations
}