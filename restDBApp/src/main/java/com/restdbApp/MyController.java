package com.restdbApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {
@Autowired
PersonService service;

@GetMapping("/person")
public java.util.List<Personn>getAllPerson(){
	return service.getAllPerson();
}
@GetMapping("/person/{pid}")
public Personn getPersonByID(@PathVariable("pid")int pid) {
	return service.getPersonById(pid);
	
}
@PostMapping("/person")
public Personn createPerson(@RequestBody Personn person) {
	System.out.println("Record Added");
	return service.repository.save(person);
}
@PutMapping("/person")
public Personn updatePerson(@RequestBody Personn person) {
	System.out.println(person);
	Personn p = service.repository.save(person);
	return p;
}
@DeleteMapping("/person/{pid}")
public Personn deleteById(@PathVariable("pid")int pid) {
	Personn person = service.getPersonById(pid);
	service.repository.delete(person);
	return person;
	
}
}