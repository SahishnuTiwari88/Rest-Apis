package com.bookrestapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	private String firstName;
	private String lastName;
	private String language;
	@OneToOne(mappedBy = "author") //it will do the mapping so that one id column is maintained in database
	@JsonBackReference // it shows now we don't have to traverse back to the previous field
	private Book book;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int authorId, String firstName, String lastName, String language) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
//	@Override
//	public String toString() {
//		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
//				+ language + ", book=" + book + "]";
//	}
//	
	
	

}
