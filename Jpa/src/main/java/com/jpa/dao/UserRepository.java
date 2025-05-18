package com.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user);

}
