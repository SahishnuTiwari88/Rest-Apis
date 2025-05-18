package com.wipro.capstone.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	//public Customer findById(int custId);

}
