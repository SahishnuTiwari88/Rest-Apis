package com.restdbApp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired PersonRepository repository;
public List<Personn> getAllPerson(){
java.util.List<Personn> records =new java.util.ArrayList<Personn>();
repository.findAll().forEach(records::add);
return records;
	}
public Personn getPersonById(Integer id) {
		return repository.findById(id).get();
	}
	public void addPerson(Personn personRecord) {
		repository.save(personRecord);
	}
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	public Personn updatePerson(Personn personn) {
		int pid=personn.getPid();
		Personn p=repository.findById(pid).get();
		p.setPid(pid);
        p.setPname(personn.getPname());
		p.setPjob(personn.getPjob());
		repository.save(p);
		return p;
		}
}