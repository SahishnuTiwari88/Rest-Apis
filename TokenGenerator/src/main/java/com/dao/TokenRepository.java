package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

	List<Token> findByCustomerId(Long customerId);
    // You can define custom queries or methods here if needed

	List<Token> findByDeskId(Long deskId);
}