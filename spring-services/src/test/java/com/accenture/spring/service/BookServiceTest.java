package com.accenture.spring.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.accenture.spring.ServiceContextTest;
import com.accenture.spring.model.Book;

public class BookServiceTest extends ServiceContextTest {

    @Test
    public void findByTitle(){
        String titleExpected = "Java";
        List<Book> books = bookService.findByTitle(titleExpected);

        books.forEach(book -> {
            String titleActual = book.getTitle();
            System.out.println(titleActual);
            Assert.assertTrue(titleActual.contains(titleExpected));
        });
    }
}

