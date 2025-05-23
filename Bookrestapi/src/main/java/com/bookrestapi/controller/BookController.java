package com.bookrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookrestapi.entity.Book;
import com.bookrestapi.services.BookService;

//@Controller  //we can use @Controller for normal mvc project =, but when working on rest project we have to use @RestController
// and due to it's use we don't have to mention @ResponseBody for getting information on the browser
@RestController
public class BookController {
	@Autowired
	private BookService bookservice;
	//@RequestMapping(path = "/books",method = RequestMethod.GET)// at place of @RequestMapping we can use @GetMapping which indicate 
	//mapping along with GET method
	//@ResponseBody
	
	//get all books
//	@GetMapping("/books")
//	public List<Book> getBooks() {
//		Book book = new Book();
//		book.setId(1999);
//		book.setTitle("Java Complete Guide");
//		book.setAuthor("R. Sambhu");
//		return this.bookservice.getAllBooks();
//	}
	
	// get all books with status code and data using ResponseEntity
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookservice.getAllBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//build is used to create proper new object which is returned
		}
		return ResponseEntity.of(Optional.of(list));//have to pass optional list with by default OK status code
	}

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getbook(@PathVariable("id")int id) {
		Book book =  bookservice.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		try {
		 b = this.bookservice.addBook(book);
		System.out.println(b);
		return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
			
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id")int id) {
		try {
		this.bookservice.deleteBook(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//update book
	@PutMapping("books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id")int id) {
		try {
		this.bookservice.updateBook(book,id);
		return ResponseEntity.ok().body(book);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
