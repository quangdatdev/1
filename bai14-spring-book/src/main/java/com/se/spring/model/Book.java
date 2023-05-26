package com.se.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BookOnline")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookID;
	private String bookName;
	private String author;
	private String publishYear;
	private String rating;
	private String imageURL;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(long bookID, String bookName, String author, String publishYear, String rating, String imageURL) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.publishYear = publishYear;
		this.rating = rating;
		this.imageURL = imageURL;
	}

	public long getBookID() {
		return bookID;
	}
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", author=" + author + ", publishYear="
				+ publishYear + ", rating=" + rating + ", imageURL=" + imageURL + "]";
	}
	
	
}
