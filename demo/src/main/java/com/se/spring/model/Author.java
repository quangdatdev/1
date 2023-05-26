package com.se.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long author_id;
	
	private String name;
    @ManyToMany
    @JoinTable(name = "book_author",
               joinColumns = @JoinColumn(name = "author_id"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;
    
    
	public Author(Long id, String name, List<Book> books) {
		super();
		this.author_id = id;
		this.name = name;
		this.books = books;
	}
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return author_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
}
