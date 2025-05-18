package com.wipro.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.dao.CustomerRepository;
import com.wipro.capstone.entity.Customer;
import com.wipro.capstone.exception.CustomerNotFoundException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository custrep;

	// display all customer
	public List<Customer> getAllCustomers() {
		List<Customer> list = (List<Customer>) custrep.findAll();
		return list;

	}

	// add customer

	public Customer addCustomer(Customer c) {
		  return custrep.save(c);
		

	}

	// display customer based on id

	public Customer getCustomerById(int custId) {
		Optional<Customer> custo = custrep.findById(custId);
		Customer customer = null;
		if (custo.isPresent()) {
			customer = custo.get();
		} else {
			throw new CustomerNotFoundException("The customer is not present " + custId);
		}
		return customer;

	}
	
	//delete customer on id
	public void deleteCustomerById(Customer customer) {
		custrep.delete(customer);
	}
	
	//update customer
	public void updateCustomer(Customer custom) {
		
		//custom.setCustId(custId);
		custrep.save(custom);
				
		
	}
	
	//delete all data
	public void delete() {
		custrep.deleteAll();
		
	}

	

	

}
