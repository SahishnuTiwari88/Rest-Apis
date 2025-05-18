package com.jpaa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpaa.entity.Person;

public interface PersonRepo extends CrudRepository<Person, Integer>{
	public List<Person> findByName(String name);
	
	//Using @Query annotation and writing our own queries
	@Query("select p from Person p")// where p is alias
	public List<Person> getAllPerson();
	
	@Query("select p from Person p where p.name =:n ") //this is formating of provide data known as parametrized query
	//now we have to pass String name to n which can be done using @Param and passing variable in the bracket like @Param("n")
	public List<Person> getUserByName(@Param("n")String name);

	//using native i.e. sql query
	@Query(value = "select * from Person",nativeQuery=true)
	public List<Person> getUsers();
	
}
