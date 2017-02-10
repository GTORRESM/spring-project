package com.accenture.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.spring.model.Book;

public interface BooksRepository extends JpaRepository<Book, String> {

	public List<Book> findByTitleLike(String nombre); 
	
	public List<Book> findByTitle(String title);

}
