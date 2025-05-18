package com.microservice.ServicesMicroService.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String servicename;
	private float fees;
}
