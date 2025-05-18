package com.accounttracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.capstone.controller.CustomerController;
import com.wipro.capstone.entity.Customer;
import com.wipro.capstone.service.CustomerService;

//import net.minidev.json.JSONObject;


@ExtendWith(MockitoExtension.class)

public class CustomerControllerTest {

	@Mock
	private CustomerService customerService;

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private CustomerController customerController;

	//private Object body;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	// Test cases go here
	@Test
	public void testGetCustomers() throws Exception {
		
		List<Customer> customers = Arrays.asList(new Customer(1, "Sonam", "VNS", null),
				new Customer(2, "Sarvesh", "Bangalore", null));
		when(customerService.getAllCustomers()).thenReturn(customers);

		
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

		// Perform the GET request and validate the response
		mockMvc.perform(get("/getcustomers"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.length()").value(2))
				.andExpect(jsonPath("$.data[0].custId").value(1))
				.andExpect(jsonPath("$.data[0].custName").value("Sonam"))
				.andExpect(jsonPath("$.data[0].custAddress").value("VNS"))
				.andExpect(jsonPath("$.data[1].custId").value(2))
				.andExpect(jsonPath("$.data[1].custName").value("Sarvesh"))
				.andExpect(jsonPath("$.data[1].custAddress").value("Bangalore"));

		// Verify that the customerService.getAllCustomers() method is called once
		verify(customerService, times(1)).getAllCustomers();
	}

	@Test
    public void testAddCustomer() throws Exception {
        // Create a mock customer
        Customer customer = new Customer(1,"John","XYZ",null);

       
        when(customerService.addCustomer(any(Customer.class))).thenReturn(customer);
        
        mockMvc.perform(post("/savecustomer")
		
		.contentType(MediaType.APPLICATION_JSON)
		.content(new ObjectMapper().writeValueAsString(customer)))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(jsonPath("$.data.custId").value(1))
		.andExpect(jsonPath("$.data.custName").value("John"))
		.andExpect(jsonPath("$.data.custAddress").value("XYZ"));
        
        verify(customerService,times(1)).addCustomer(any(Customer.class));
        
    }

	@Test
	public void testGetById()throws Exception {
		// Create a mock customer
		Customer customer = new Customer(1,"Sahishnu","Bangalore",null);
	
		when(customerService.getCustomerById(1)).thenReturn(customer);

	
		mockMvc.perform(get("/customer/{id}",1)
				.contentType(MediaType.APPLICATION_JSON))
		  		.andExpect(status().isOk());
		        assertEquals(1, customer.getCustId());
		        assertEquals("Sahishnu", customer.getCustName());
		
	verify(customerService,times(1)).getCustomerById(1);
	}


	@Test
	public void testDeleteById() throws Exception {
	    // Create a mock customer
		 Customer customer = new Customer(1,"Sahishnu","XYZ",null);

	    // Mock the behavior of the customerService.getCustomerById() method
	    when(customerService.getCustomerById(1)).thenReturn(customer);

	    // Perform the delete request
	     mockMvc.perform(delete("/delete/{id}", 1))
	            .andExpect(status().isOk())
	            .andReturn();

	  
	}




	@Test
	public void testUpdateById() throws Exception {
	    // Create a mock customer
	    Customer customer = new Customer(1, "Sarvesh", "Bangalore", null);
	    
	    // Mock the behavior of the customerService.getCustomerById() method
	    

	    // Create a mock updated customer
	    Customer updatedCustomer = new Customer();
	    updatedCustomer.setCustId(customer.getCustId());
	    updatedCustomer.setCustName("Sahishnu");
	    updatedCustomer.setCustAddress("XYZ");
	    
	    when(customerService.getCustomerById(1)).thenReturn(updatedCustomer);
	
	    mockMvc.perform(put("/update/{id}", 1)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(new ObjectMapper().writeValueAsString(updatedCustomer)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.data.custName").value("Sahishnu"))
	            .andExpect(jsonPath("$.data.custAddress").value("XYZ"));
	           


	    // Verify the customerService.addCustomer() method is called
	    verify(customerService, times(1)).addCustomer(updatedCustomer);

	
	}




	@Test
	public void testDeleteAllCustomers() throws Exception {
		// Create a mock list of customers
		List<Customer> customers = Arrays.asList(new Customer(1,"Sahishnu","XYZ",null), new Customer(2,"Sarvesh","Mau",null));

		// Mock the behavior of the customerService.getAllCustomers() method
		when(customerService.getAllCustomers()).thenReturn(customers);

	
		 mockMvc.perform(delete("/deleteall"))
         .andExpect(status().isOk())
         .andReturn();
	}

}


