package com.wipro.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.dao.BankRepository;
import com.wipro.capstone.entity.BankAccount;
import com.wipro.capstone.exception.BankNotFoundException;

@Service
public class BankService {
     @Autowired
	private BankRepository bankrep;
     
     public List<BankAccount> getAllAccounts(){
    	 List<BankAccount> list = (List<BankAccount>) bankrep.findAll();
    	 return list;
    	 
     }
     
     
     //find Bank account by id
     public BankAccount getBankById(int id) {
    	 Optional<BankAccount> bank = bankrep.findById(id);
    	 BankAccount account = null;
    	 if(bank.isPresent()) {
    		 account = bank.get();
    	 }
    	 else {
    		 throw new BankNotFoundException("The bank account not found "+id);
    	 }
    	 return account;
     }
     
     
//     public void updateBankAccount(BankAccount bank) {
//    	 bankrep.save(bank);
//     }
     public void updateBankDetail(BankAccount bank) {
    	 
//    	 bankrep.save(bank,bank1);
    	 bankrep.save(bank);
     }
     

}
