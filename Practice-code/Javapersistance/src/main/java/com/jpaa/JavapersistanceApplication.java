package com.jpaa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpaa.dao.PersonRepo;
import com.jpaa.entity.Person;

@SpringBootApplication
public class JavapersistanceApplication {

	public static void main(String[] args) {
	ApplicationContext context = 	SpringApplication.run(JavapersistanceApplication.class, args);
	PersonRepo personre = context.getBean(PersonRepo.class);
	//Person per = new Person();
	//create
	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("Enter name :");
//	String name = sc.next();
//	System.out.println("Enter city :");
//	String city = sc.next();
//	System.out.println("Enter status :");
//	String status = sc.next();
//	per.setName(name);
//	per.setUcity(city);
//	per.setUstatus(status);
//	Person per1 = personre.save(per);
//	System.out.println(per1);
	
	//saving multiple object/data all together
//	List<Person> user = List.of(per1,per2);
//	
//	Iterable<Person> result = personre.saveAll(user);
//	//print data
//	result.forEach(user->{
//		System.out.println(user);
//	});
	
	//Update
//	System.out.println("Enter id to change info ");
//	int id = sc.nextInt();
//	Optional<Person> optional = personre.findById(id);
//	Person per = optional.get();
//	System.out.println("Enter name :");
//	String name = sc.next();
//	System.out.println("Enter city :");
//	String city = sc.next();
//	System.out.println("Enter status :");
//	String status = sc.next();
//	per.setName(name);
//	per.setUcity(city);
//	per.setUstatus(status);
//	Person per1 = personre.save(per);
//	System.out.println(per1);
	
	
	//get single data
	
//	System.out.println("Enter id to change info ");
//	int id = sc.nextInt();
//	Optional<Person> optional = personre.findById(id);
//	Person per = optional.get();
//	System.out.println(per);
//	
	
	//get all data
	
//Iterable<Person> itr = personre.findAll();
//for(Person Person:itr) {
//	System.out.println(Person);
//	
//}

	//delete
//	System.out.println("Enter id to delete info ");
//	int id = sc.nextInt();
//	personre.deleteById(id);
//	System.out.println("deleted sussefully");

	//delete all users using iterable
	
//	Iterable<Person>allper = personre.findAll();
//	for(Person person:allper) {
//		System.out.println(person);
//	}
//	personre.deleteAll(allper);
	
	//Custom finder method/derived method
//	List<Person> person=personre.findByName("Sarvesh");
//	for(Person per : person) {
//		System.out.println(per);
//	}
//	
	
	//Custom finder method using @Query it is jpql
	List<Person> per = personre.getAllPerson();
	for(Person p:per) {
		System.out.println(p);
	}
	
	System.out.println("----------------------------------------------------------------------");
	
	//get user with particular name using @Query
	List<Person> pers = personre.getUserByName("Sarvesh");
	for(Person p:pers) {
		System.out.println(p);
	}
	
	System.out.println("----------------------------------------------------------------------");
	
	//native sql query
	List<Person> person = personre.getUsers();
	for(Person p:person) {
	System.out.println(p);
	}
	}

}
