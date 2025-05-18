package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Desk;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {
    // You can define custom queries or methods here if needed
}