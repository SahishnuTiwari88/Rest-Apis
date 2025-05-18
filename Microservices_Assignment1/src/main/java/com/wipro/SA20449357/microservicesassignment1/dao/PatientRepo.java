package com.wipro.SA20449357.microservicesassignment1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.SA20449357.microservicesassignment1.entities.Patients;
@Repository
public interface PatientRepo extends JpaRepository<Patients, Long> {

}
