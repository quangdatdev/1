package com.se.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.spring.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

//	void saveBookAuthor(Long bookId, Long id);

}
