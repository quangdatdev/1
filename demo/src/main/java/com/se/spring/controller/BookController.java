package com.se.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.se.spring.model.Author;
import com.se.spring.model.Book;
import com.se.spring.services.AuthorService;
import com.se.spring.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookController {

	private final BookServices bookServices;
	private final AuthorService authorService;

	public BookController(BookServices bookServices, AuthorService authorService) {
		this.bookServices = bookServices;
		this.authorService = authorService;
	}

	@GetMapping({ "", "/list" })
	public ModelAndView findAllBook() {
		ModelAndView model = new ModelAndView();
		model.addObject("books", bookServices.findAll());
		model.setViewName("book_listing");
		return model;
	}

	@PostMapping("/saveBook")
	public ModelAndView saveBook(@ModelAttribute Book book, @RequestParam(value = "authorIds", required = false) List<Long> authorIds) {
		ModelAndView model = new ModelAndView();
//		List<Author> authors = new ArrayList<>();
//		if (authorIds != null) {
//		    for (Long authorId : authorIds) {
//		        Optional<Author> optionalAuthor = authorService.findById(authorId);
//		        if (optionalAuthor.isPresent()) {
//		            Author author = optionalAuthor.get();
//		            authors.add(author);
//		            authorService.saveBookAuthor(book.getId(), author.getId());
//		        }
//		    }
//		}
//		book.setAuthors(authors);
		bookServices.save(book);
		model.setViewName("redirect:/book");
		return model;
	}

	@GetMapping("/showAddForm")
	public ModelAndView showAddForm() {
		ModelAndView modelAndView = new ModelAndView();
		List<Author> ls = authorService.findAll();
		modelAndView.addObject("allAuthors",ls);
		modelAndView.addObject("book", new Book());
		modelAndView.setViewName("add_book_form");
		return modelAndView;
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam long id) {
		ModelAndView modelAndView = new ModelAndView();
		Book book = bookServices.findById(id).get();
		modelAndView.addObject("book", book);
		modelAndView.setViewName("add_book_form");
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView deleteProduct(long id) {
		ModelAndView model = new ModelAndView();
		Book book = bookServices.findById(id).get();
		bookServices.delete(book);
		model.setViewName("redirect:/book");
		return model;
	}
}
