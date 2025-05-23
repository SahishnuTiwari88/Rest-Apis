package com.tokengenerate.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokengenerate.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	boolean existsByMobileNumber(String mobileNumber);

	Optional<Customer> findById(int customerId);

}
