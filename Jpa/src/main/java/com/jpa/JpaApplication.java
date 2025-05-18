package com.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.dao.UserRepository;
import com.jpa.entity.User;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(JpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		//user.setId(1);
		user.setName("Sarvesh Tiwari");
		user.setUcity("Mau");
		user.setUstatus("Java developer");
		User user1 = userRepository.save(user);
		System.out.println(user1);
		
	}

}
