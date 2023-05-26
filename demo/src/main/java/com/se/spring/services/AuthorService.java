package com.se.spring.services;

import java.util.List;
import java.util.Optional;

import com.se.spring.model.Author;

public interface AuthorService {
	void save(Author author);

	List<Author> findAll();

	Optional<Author> findById(long id);

	void delete(Author author);

	/**
	 * 
	 * @param id
	 * @return Trả về true nếu như xóa thành công
	 */
	boolean delete(long id);
	
	void saveBookAuthor(Long bookIds, Long id);
}
