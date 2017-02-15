package com.accenture.spring.service;

import java.util.List;

import com.accenture.spring.model.Book;

public interface BookService {
	
    List<Book> findByTitle(String title);
}
