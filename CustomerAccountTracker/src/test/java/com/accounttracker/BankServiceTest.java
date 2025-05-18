package com.accounttracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wipro.capstone.dao.BankRepository;
import com.wipro.capstone.entity.BankAccount;
import com.wipro.capstone.service.BankService;

class BankServiceTest {

	@InjectMocks
	private BankService bankser;
	
	@Mock
	private BankRepository bankrep;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		
	}
	@Test
	public void testGetAllAccount() {
		List<BankAccount> bank = new ArrayList<>();
		bank.add(new BankAccount(1,"Saving",12000,null));
		bank.add(new BankAccount(2,"Current",10000,null));
		when(bankrep.findAll()).thenReturn(bank);
		List<BankAccount> list = bankser.getAllAccounts();
		assertEquals(bank.size(),list.size());
		assertEquals("Saving",list.get(0).getAccType());
		assertEquals("Current",list.get(1).getAccType());
	}
	@Test
	public void testGetBankById() {
		BankAccount bank = new BankAccount(2,"Current",30000,null);
		when(bankrep.findById(1)).thenReturn(Optional.of(bank));
		assertEquals("Current",bank.getAccType());
		assertEquals(2,bank.getAccId());
	}
	
	@Test
	public void testUpdateBankDetail() {
		BankAccount bank = new BankAccount(3,"Unknown",25000,null);
		
		bankrep.save(bank);
		
		
		bank.setAccId(bank.getAccId());
		bank.setAccType("Saving");
		bank.setAccBalance(30000);
		bankrep.save(bank);
		
		when(bankrep.findById(bank.getAccId())).thenReturn(Optional.of(bank));
		
		assertEquals("Saving",bank.getAccType());		
		
	}

}
