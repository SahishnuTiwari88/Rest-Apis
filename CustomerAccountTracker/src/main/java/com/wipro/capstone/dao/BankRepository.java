package com.wipro.capstone.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.entity.BankAccount;
@Repository
public interface BankRepository extends CrudRepository<BankAccount, Integer> {

	//void save(Optional<BankAccount> bank1);
	//public void Transfer(int sId,int dId,int amount);
	

}
