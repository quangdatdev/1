package com.se.spring.services;

import java.util.List;
import java.util.Optional;

import com.se.spring.model.Book;

public interface BookServices {

	void save(Book book);
	
	List<Book> findAll();
	
	Optional<Book> findById(long id);
	
	void delete(Book book);
	/**
	 * 
	 * @param id
	 * @return Trả về true nếu như xóa thành công
	 */
	boolean delete(long id);
}
