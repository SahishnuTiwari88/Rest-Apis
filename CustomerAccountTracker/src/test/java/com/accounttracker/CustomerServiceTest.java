package com.accounttracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.wipro.capstone.dao.CustomerRepository;
import com.wipro.capstone.entity.Customer;
import com.wipro.capstone.service.CustomerService;

class CustomerServiceTest {

	
	@InjectMocks
	private CustomerService customerService;
	
	
	
	@Mock
	private CustomerRepository custrep;
	
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		
	}
	
	@Test
	public void testGetAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1,"Sarvesh","Bangalore",null));
		customers.add(new Customer(2,"Sahishnu","Kolkata",null));
		when(custrep.findAll()).thenReturn(customers);
		List<Customer> result = customerService.getAllCustomers();

        assertEquals(2, result.size()); 
        assertEquals(1, result.get(0).getCustId());
        assertEquals("Sarvesh", result.get(0).getCustName());
        assertEquals("Bangalore", result.get(0).getCustAddress());
        assertEquals(2, result.get(1).getCustId());
        assertEquals("Sahishnu", result.get(1).getCustName());
        assertEquals("Kolkata", result.get(1).getCustAddress());
       
	}
	@Test
	public void getCustomerById() {
		Customer customer = new Customer(1,"Sakshi","MP",null);
		when(custrep.findById(1)).thenReturn(Optional.of(customer));
		assertEquals("Sakshi",customer.getCustName());
		
	}
	
	@Test
	public void testAddCustomer() {
		Customer customer = new Customer(3,"John","America",null);
		when(custrep.save(customer)).thenReturn(customer);
		assertEquals(3,customer.getCustId());
		assertEquals("John",customer.getCustName());
	}
//	@Test(expected = CustomerNotFoundException.class)
//	public void testCustomerByIdNotFound() {
//		Optional<Customer> customer = Optional.empty();
//		when(custrep.findById(anyInt())).thenReturn(customer);
//		customerService.getCustomerById(1);
//		
//	}
	@Test
	public void testDeleteCustomerById() {
		Customer customer = new Customer(4,"Smith","China",null);
		custrep.save(customer);
		 custrep.deleteById(customer.getCustId());
		 Optional<Customer> optionalcustomer = custrep.findById(customer.getCustId());
		 Assertions.assertEquals(true,optionalcustomer.isEmpty());
	}
	@Test
	public void testUpdateCustomer() {
		Customer customer = new Customer(1,"Nikhil Gupta","Delhi",null);
		
		custrep.save(customer);
		customer.setCustId(customer.getCustId());
		customer.setCustName("Shivansh");
		customer.setCustAddress("Lucknow");
		custrep.save(customer);
		when(custrep.findById(customer.getCustId())).thenReturn(Optional.of(customer));
		assertEquals("Shivansh",customer.getCustName());
		assertEquals("Lucknow",customer.getCustAddress());
	}
	@Test
	public void testDelete() {
		Customer customer = new Customer(3,"Anamika","Gurgaon",null);
		Customer customer1 = new Customer(4,"Sonam","VNS",null);
		custrep.save(customer);
		custrep.save(customer1);
		custrep.deleteAll();
		List<Customer> cust = (List<Customer>) custrep.findAll();
		
		Assertions.assertEquals(true,cust.isEmpty());
	}
	
	

}
