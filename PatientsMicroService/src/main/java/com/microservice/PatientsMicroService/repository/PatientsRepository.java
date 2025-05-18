package com.microservice.PatientsMicroService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.PatientsMicroService.entities.Patients;
@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer>{

}
