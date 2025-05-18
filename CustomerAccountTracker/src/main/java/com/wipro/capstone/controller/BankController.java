package com.wipro.capstone.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wipro.capstone.entity.BankAccount;
import com.wipro.capstone.service.BankService;

@RestController
public class BankController {
	@Autowired
	private BankService bankserv;
	
	
	//get all accounts
	@GetMapping("/accounts")
	public ResponseEntity<?> getAccounts(){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		List<BankAccount> list = bankserv.getAllAccounts();
		if(!list.isEmpty()) {
			JsonOutput.put("status", 1);
			JsonOutput.put("data", list);
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
		}
		else {
			JsonOutput.clear();
			JsonOutput.put("status",0);
			JsonOutput.put("massage", "No bank account details found");
			return new ResponseEntity<>(JsonOutput,HttpStatus.NOT_FOUND);
		}
	}
	
	//transaction using put mapping
	@PutMapping("/update/{id1}/{id2}/{amount}")
	public ResponseEntity<?> updateBankDetail(@RequestBody BankAccount bankacc, @PathVariable("id1")int sId,
			@PathVariable("id2")int dId, @PathVariable("amount")int amount){
		Map<String, Object> JsonOutput = new LinkedHashMap<>();
		BankAccount bank1 = bankserv.getBankById(sId);
		BankAccount bank2 = bankserv.getBankById(dId);
		if((bank1.getAccId()!=0 && bank2.getAccId()!=0) && (!(bank1.getAccId()==(bank2.getAccId()))) && amount>1) {
			bank1.setAccId(bankacc.getAccId());
			bank1.setAccType(bankacc.getAccType());
			bank1.setAccBalance(bankacc.getAccBalance()-amount);
			
			bankserv.updateBankDetail(bank1);
			
			bank2.setAccId(dId);
			bank2.setAccType(bank2.getAccType());
			bank2.setAccBalance(bank2.getAccBalance()+amount);
			
			bankserv.updateBankDetail(bank2);

			
			
			JsonOutput.put("status", 1);
			JsonOutput.put("message", "Amount transfered successufully");
			JsonOutput.put("data", bank1);
			return new ResponseEntity<>(JsonOutput,HttpStatus.OK);
			
		}
		else {
			JsonOutput.clear();
			JsonOutput.put("status", 0);
			JsonOutput.put("message", "Not found");
			return new ResponseEntity<>(JsonOutput,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

}
