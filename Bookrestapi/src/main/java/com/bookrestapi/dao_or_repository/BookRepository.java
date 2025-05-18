package com.bookrestapi.dao_or_repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookrestapi.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{
	public Book findById(int id);

}
