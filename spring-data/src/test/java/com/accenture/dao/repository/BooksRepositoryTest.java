package com.accenture.dao.repository;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.BootstrapWith;

import com.accenture.dao.PersistenceContextTest;
import com.accenture.spring.model.Book;

public class BooksRepositoryTest extends PersistenceContextTest {
	
	@Test
	public void count(){
				
		long numberBooks = bookRepository.count();
		Assert.assertTrue(numberBooks > 0);
	}
	
	@Test
	public void findAllBooks(){		
		List<Book> books = bookRepository.findAll();
		Assert.assertFalse(books.isEmpty());
	}

	@Test
	public void findByTitle(){		
		String titleExpected = "Java";
		List<Book> books = bookRepository.findByTitle(titleExpected);
		String titleActual = books.get(0).getTitle();
		Assert.assertTrue(titleActual.contains(titleExpected));
	}
	
	@Test
	public void saveUpdate(){
		Book book = new Book();
		book.setIsbn("B4");
		book.setTitle("Book 4");
		book.setDateOfPublication(new Date());
		Book newBook = bookRepository.saveAndFlush(book);
		Assert.assertNotNull(newBook);
		Assert.assertEquals(newBook.getIsbn(), book.getIsbn());
	} 
	
	@Test
	public void delete(){
		Book book = new Book();
		book.setIsbn("B4");
		Assert.assertNotNull(book);
		bookRepository.delete(book);
		book = bookRepository.findByIsbn("B4");
		Assert.assertNull(book);
	}
}

