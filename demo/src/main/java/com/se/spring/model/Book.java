package com.se.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 5)
	private long id;
	private String title;
	private String publicationYear;
	
	@ManyToMany(mappedBy = "books")
	private List<Author> authors;
	
	
	
	public Book(long id, String title, String publicationYear, List<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.publicationYear = publicationYear;
		this.authors = authors;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public String getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publicationYear=" + publicationYear + ", authors=" + authors
				+ "]";
	}
	
	
	
	
}
