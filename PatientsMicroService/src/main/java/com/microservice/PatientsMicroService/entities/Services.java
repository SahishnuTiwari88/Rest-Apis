package com.microservice.PatientsMicroService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Services {
	
	private int id;
	private String servicename;
	private float fees;
}
