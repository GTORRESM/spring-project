package com.accenture.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.accenture.dao.repository.BooksRepository;
import com.accenture.spring.model.Book;
import com.accenture.spring.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BooksRepository bookRepository;

	@Override
	public List<Book> findByTitle(String title) {
		return bookRepository.findByTitleLike(title);
	}
	
	@Override
	public Book addUpdateBook(Book book){
		bookRepository.saveAndFlush(book);
		return book;
	}


	@Override
	public void remove(Book book) {
		bookRepository.delete(book);
	}
	
	public void removeById(String id) {
		Book book = new Book();
		book.setIsbn(id);
		remove(book);
	}


	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}


	@Override
	public Book findById(String id) {
		Book book;
		if(StringUtils.isEmpty(id)){
			book = new Book();
		}else{
			book = bookRepository.findByIsbn(id);
		}
		return book;
	}
}
