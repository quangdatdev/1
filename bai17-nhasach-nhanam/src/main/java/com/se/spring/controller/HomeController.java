package com.se.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.se.spring.model.TacGia;
import com.se.spring.model.TacPham;
import com.se.spring.repositories.TacGiaRepository;
import com.se.spring.services.TacGiaService;
import com.se.spring.services.TacPhamService;

@RestController
@RequestMapping("/book")
public class HomeController {

	private final ResourceLoader resourceLoader;

	private final TacPhamService tacPhamService;
	private final TacGiaService tacGiaService;


	public HomeController(ResourceLoader resourceLoader, TacPhamService tacPhamService, TacGiaService tacGiaService) {
		this.resourceLoader = resourceLoader;
		this.tacPhamService = tacPhamService;
		this.tacGiaService = tacGiaService;
	}

	@GetMapping({ "", "/list" })
	public ModelAndView findAllBook() {
		ModelAndView model = new ModelAndView();
		model.addObject("dstacpham", tacPhamService.findAll());
		model.addObject("dstacgia",tacGiaService.findAll());
		model.setViewName("book_list");
		return model;
	}
	
	@GetMapping("/details")
	public ModelAndView showDetailsBook( long id) {
		ModelAndView model = new ModelAndView();
		TacPham book = tacPhamService.findById(id).get();
		model.addObject("tacpham",book);
		model.setViewName("book_details");
		return model;
	}
	

	@PostMapping("/saveBook")
	public ModelAndView saveBook(@ModelAttribute TacPham book,@RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request) {
		  // Lưu file vào thư mục trên máy tính
	    String fileName = imageFile.getOriginalFilename();

	    try {
	        String uploadDir = resourceLoader.getResource("classpath:static/img/").getFile().getAbsolutePath();
	        // Đường dẫn tới thư mục lưu ảnh
	        String filePath = uploadDir + fileName;
	        File dest = new File(filePath);
	        imageFile.transferTo(dest);
	        // Lưu đường dẫn vào đối tượng book
	        String relativePath = request.getContextPath() + "/img/" + fileName;
	        book.setHinh(relativePath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		ModelAndView model = new ModelAndView();
		long mtg = book.getTacGia().getMaTacGia();
		TacGia tg = tacGiaService.findById(mtg).get();
		book.setTacGia(tg);
		tacPhamService.save(book);
		model.setViewName("redirect:/book");
		return model;
	}

	@GetMapping("/showAddForm")
	public ModelAndView showAddForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dstacgia",tacGiaService.findAll());
		modelAndView.addObject("book", new TacPham());
		modelAndView.setViewName("add_book_form");
		return modelAndView;
	}

//	@GetMapping("/showUpdateForm")
//	public ModelAndView showUpdateForm(@RequestParam long id) {
//		ModelAndView modelAndView = new ModelAndView();
//		Book book = bookServices.findById(id).get();
//		modelAndView.addObject("book", book);
//		modelAndView.setViewName("add_book_form");
//		return modelAndView;
//	}
//
//	@GetMapping("/delete")
//	public ModelAndView deleteBook(long id) {
//		ModelAndView model = new ModelAndView();
//		Book book = bookServices.findById(id).get();
//		bookServices.delete(book);
//		model.setViewName("redirect:/book/manageBooks");
//		return model;
//	}
//	
//	@GetMapping("/manageBooks")
//	public ModelAndView manageBooks() {
//	    ModelAndView model = new ModelAndView("manage_books");
//	    // Lấy danh sách sách từ service/repository
//	    model.addObject("books", bookServices.findAll());
//	    return model;
//	}
}
