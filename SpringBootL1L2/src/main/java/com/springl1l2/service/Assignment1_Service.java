package com.springl1l2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springl1l2.dao.Assignment1_Repository;
import com.springl1l2.entity.Assignment1;

@Service
public class Assignment1_Service {
	@Autowired
	private Assignment1_Repository assinrep;

	public List<Assignment1> getAllBankName(){
		List<Assignment1> assignment1 = assinrep.findAll();
		return assignment1;
	}

	
//	public List<Assignment1> getAllBankAddress() {
//		List<Assignment1> address = assinrep.getAddress();
//		return address;
//
//	}
	
	
	public void addBank(Assignment1 assign) {
		assinrep.save(assign);
		
	}

}
