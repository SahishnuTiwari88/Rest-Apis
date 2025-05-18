package com.accounttracker;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

//package com.wipro.capstone.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.capstone.controller.BankController;
import com.wipro.capstone.entity.BankAccount;
import com.wipro.capstone.service.BankService;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest({BankController.class,BankService.class})
public class BankControllerTest {
	private MockMvc mockMvc;

	@Mock
	private BankService bankService;

	@InjectMocks
	private BankController bankController;
	@BeforeEach
	public void setup() {
		//bankService = mock(BankService.class);
		
		mockMvc = MockMvcBuilders.standaloneSetup(bankController).build();
	}

	@Test
    public void testGetAccounts() throws Exception {
		
        
        BankAccount account1 = new BankAccount(1, "Savings", 1000,null);
        
        BankAccount account2 = new BankAccount(2, "Checking", 500,null);
      //  when(bankService.getAllAccounts()).thenReturn(Arrays.asList(account1, account2));
        
        when(bankService.getAllAccounts()).thenReturn(Arrays.asList(account1,account2));

        mockMvc = MockMvcBuilders.standaloneSetup(bankController).build();

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data[0].accId").value(1))
                .andExpect(jsonPath("$.data[0].accType").value("Savings"))
                .andExpect(jsonPath("$.data[0].accBalance").value(1000))
                .andExpect(jsonPath("$.data[1].accId").value(2))
                .andExpect(jsonPath("$.data[1].accType").value("Checking"))
                .andExpect(jsonPath("$.data[1].accBalance").value(500));
    }

	@Test
	public void testUpdateBankDetail() throws Exception {
	    // Prepare test data
	    BankAccount sourceAccount = new BankAccount(1, "Savings", 1000,null);
	    BankAccount destinationAccount = new BankAccount(2, "Checking", 500,null);
	    int amount = 200;
	    
	   
	    //bankService.updateBankDetail(destinationAccount);

	    // Mock the service methods
	    when(bankService.getBankById(1)).thenReturn(sourceAccount);
	    when(bankService.getBankById(2)).thenReturn(destinationAccount);

	    // Perform the PUT request
	    mockMvc.perform(put("/update/{id1}/{id2}/{amount}", 1, 2, amount)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content("{\"accId\": 1, \"accType\": \"Savings\", \"accBalance\": 1000}")) // Add the request body here
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("$.status").value(1))
	           // .andExpect(jsonPath("$.message").value("Amount transferred successfully"))
	            .andExpect(jsonPath("$.data.accId").value(sourceAccount.getAccId()))
	            .andExpect(jsonPath("$.data.accType").value(sourceAccount.getAccType()))
	            .andExpect(jsonPath("$.data.accBalance").value(800));

	    // Verify that the service methods were called with the correct arguments
	    verify(bankService,times(1)).updateBankDetail(sourceAccount);
	    verify(bankService,times(1)).updateBankDetail(destinationAccount);
	}
	
	//both source and destination accounts are same
	@Test
	public void testTransferFunds_WithSameAccount() throws Exception{
		BankAccount account = new BankAccount(1, "Savings", 200,null);
		int amount=100;
		 when(bankService.getBankById(1)).thenReturn(account);
		 mockMvc.perform(put("/update/{id1}/{id2}/{amount}", 1, 1, amount)
		            .contentType(MediaType.APPLICATION_JSON)
		            .content("{\"accId\": 1, \"accType\": \"Savings\", \"accBalance\": 200}")) // Add the request body here
		            .andExpect(status().isBadRequest())
		            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		            .andExpect(jsonPath("$.status").value(0))
		           .andExpect(jsonPath("$.message").value("Not found"));

	}
	
	
	//different account but not valid amount not transfer i.e. transfer amount should be greater than 1
	@Test
	public void testTransferFunds_WithDifferentAccount() throws Exception{
		BankAccount account = new BankAccount(1, "Savings", 200,null);
		BankAccount account1 = new BankAccount(2, "Savings", 100,null);
		int amount=-1;
		 when(bankService.getBankById(1)).thenReturn(account);
		 when(bankService.getBankById(2)).thenReturn(account1);
		 mockMvc.perform(put("/update/{id1}/{id2}/{amount}", 1, 2, amount)
		            .contentType(MediaType.APPLICATION_JSON)
		            .content("{\"accId\": 1, \"accType\": \"Savings\", \"accBalance\": 200}")) // Add the request body here
		            .andExpect(status().isBadRequest())
		            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		            .andExpect(jsonPath("$.status").value(0))
		           .andExpect(jsonPath("$.message").value("Not found"));

	}
	
	//Account id which not exist
	
	@Test
	public void testUpdateBankDetail_DestinationAccountNotFound() throws Exception {
        int sId = 1;
        int dId = 2;
        int amount = 100;

        // Mocking the service method to return null for the destination account
        when(bankService.getBankById(eq(sId))).thenReturn(new BankAccount());
        when(bankService.getBankById(eq(dId))).thenReturn(null);

        Map<String, Object> requestPayload = new LinkedHashMap<>();
        requestPayload.put("accId", 1);
        requestPayload.put("accType", "Savings");
        requestPayload.put("accBalance", 1000);

        mockMvc.perform(MockMvcRequestBuilders.put("/update/{id1}/{id2}/{amount}", sId, dId, amount)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(requestPayload)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Not found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").doesNotExist());

        // Verify that the service method was called with the correct arguments
        verify(bankService, times(1)).getBankById(eq(sId));
        verify(bankService, times(1)).getBankById(eq(dId));
        verify(bankService, never()).updateBankDetail(any());
	}
	
	 // Helper method to convert an object to JSON
    private static String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
	


}
