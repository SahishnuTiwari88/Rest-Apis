package com.springl1l2.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class Indicator implements HealthIndicator{

	@Override
	public Health health() {
		// TODO Auto-generated method stub
		return Health.up().build();
	}
	

}
