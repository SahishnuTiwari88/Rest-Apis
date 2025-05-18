package com.springl1l2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.springl1l2.entity.Assignment1;

@SpringBootApplication
public class SpringBootL1L2Application {

	public static void main(String[] args) {
		ApplicationContext con =  SpringApplication.run(SpringBootL1L2Application.class, args);
		String[] beans = con.getBeanNamesForType(Assignment1.class);
		for(String bean:beans) {
		System.out.println(bean);
		}
		
	}

}
