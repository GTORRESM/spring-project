package com.accenture.spring.service;

import java.util.List;

import com.accenture.spring.model.Book;

public interface BookService {
	
    List<Book> findByTitle(String title);
    
    Book addUpdateBook(Book book);
    
    void remove(Book book);
    
    List<Book> findAll();
    
    Book findById(String id);

	void removeById(String id);
}
