package com.se.spring.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.se.spring.model.Book;
import com.se.spring.repositories.BookRepository;
import com.se.spring.services.BookServices;

@Service
public class BookServiceImpl implements BookServices{

	private final BookRepository bookRepository;
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> findById(long id) {
		return bookRepository.findById(id);
	}

	@Override
	public void delete(Book book) {

		bookRepository.delete(book);
	}

	@Override
	public boolean delete(long id) {
		 Optional<Book> op = bookRepository.findById(id);
	        if(op.isPresent()){
	        	Book book = op.get();
	            delete(book);
	            return true;
	        }
		return false;
	}

}
