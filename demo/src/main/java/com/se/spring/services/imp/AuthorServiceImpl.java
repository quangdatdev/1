package com.se.spring.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.se.spring.model.Author;
import com.se.spring.repositories.AuthorRepository;
import com.se.spring.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public void save(Author author) {
		authorRepository.save(author);
	}

	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> findById(long id) {

		return authorRepository.findById(id);
	}

	@Override
	public void delete(Author author) {
		delete(author);

	}

	@Override
	public boolean delete(long id) {
		Optional<Author> op = authorRepository.findById(id);
        if(op.isPresent()){
        	Author author = op.get();
            delete(author);
            return true;
        }
	return false;
	}

	@Override
	public void saveBookAuthor(Long bookIds, Long id) {
		// TODO Auto-generated method stub
//		authorRepository.saveBookAuthor(bookIds, id);
	}

}
