package com.accenture.spring.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.spring.model.Book;
import com.accenture.spring.service.BookService;

@Controller
@RequestMapping(value = { "/bookController" })
public class BookController {

	private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	private String indexBook = "bookSearch";
	private String editBook = "bookEdit";

	@Autowired
	private BookService bookService;

	@GetMapping
	@RequestMapping(value = {"bookList"})
	public String bookList(Model model) {
		LOGGER.info("Getting book list");
		List<Book> books = bookService.findAll();
		model.addAttribute("bookList", books);
		return indexBook;
	}
	
	@GetMapping
	@RequestMapping(value={"findBook"})
	public String frindBook(@RequestParam String id, Model model){
		LOGGER.info("Book modification");
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return editBook;
	}
	
	@GetMapping
	@RequestMapping(value={"removeBook"})
	public String removeBook(@RequestParam String id){
		LOGGER.info("Removing book");
		bookService.removeById(id);
		return "redirect:bookList";
	}
	
	@PostMapping
	@RequestMapping(value={"saveBook"})
	public String saveBook(@ModelAttribute Book book){
		LOGGER.info("Removing book");
		bookService.addUpdateBook(book);
		return "redirect:bookList";
	}
}
