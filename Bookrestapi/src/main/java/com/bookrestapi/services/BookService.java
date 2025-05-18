package com.bookrestapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookrestapi.dao_or_repository.BookRepository;
import com.bookrestapi.entity.Book;

@Service //or @Component
public class BookService {
	@Autowired
	private BookRepository bookrep;

//	public static List<Book> list = new ArrayList<>();
//
//	static {
//		list.add(new Book(1999, "Java Complete Guide", "R.Sambhu"));
//		list.add(new Book(2341, "Python programming", "Dr. Chuck"));
//		list.add(new Book(9234, "The tell of Nine Tails", "Mikoto"));
//		list.add(new Book(9, "The tell of the Nine Tails", "Sarvesh"));
//
//	}

	// get all books
	public List<Book> getAllBooks() {
		List<Book>list = (List<Book>) bookrep.findAll();
		return list;
	}

	// get single book by id
//	public Book getBookByIdd(int id) {
//		Book book = null;
//		for (Book b : list) {
//			if (b.getId() == id)
//				book = b.getTitle();
//
//		}
//
//	}
	// get single book by id

	public Book getBookById(int id) {
		Book book = bookrep.findById(id);
		return book;
//		Book book = null;
//		try {
//		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return book;
		
	}
	
	//adding book
	public Book addBook(Book b) {
		Book result = bookrep.save(b);
		return result;
	}
	
	//delete book
	public void deleteBook(int id) {
		
//		for(Book b:list) {
//			if(b.getId()==id) 
//			 list.remove(b);
//			//list.remove
//			
//			
//		}
		//list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		bookrep.deleteById(id);
		
	}
	//update book
	public void updateBook(Book book,int id) {
//		for(Book b:list) {
//			if(b.getId()==id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			
//		}
		book.setId(id);
		bookrep.save(book);
	}

}

// in order to send status code we have a class called ResponseEntity which is child class of HttpEntity
//with the help of ResponseEntity we can send status code along with the data, ResponseEntity followed by type<Book> 
