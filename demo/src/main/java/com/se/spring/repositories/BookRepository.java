package com.se.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.spring.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
