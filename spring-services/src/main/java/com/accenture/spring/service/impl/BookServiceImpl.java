package com.accenture.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.dao.repository.BooksRepository;
import com.accenture.spring.model.Book;
import com.accenture.spring.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BooksRepository bookRepository;

	@Override
	public List<Book> findByTitle(String title) {
		//Aqui se hacen muchas cosas 
		return bookRepository.findByTitleLike(title);
	}
}
