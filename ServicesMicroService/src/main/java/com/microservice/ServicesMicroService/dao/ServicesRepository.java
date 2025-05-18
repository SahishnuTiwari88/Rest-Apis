package com.microservice.ServicesMicroService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ServicesMicroService.entities.Services;
@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

}
