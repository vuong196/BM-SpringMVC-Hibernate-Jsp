
package com.bm.spring.service;

import java.util.List;

import com.bm.spring.entity.Book;

public interface BookService {

	public void addBook(Book a) throws Exception;

	public void deleteBook(int id) throws Exception;

	public Book getBookById(int id) throws Exception;

	public List<Book> getBookList() throws Exception;

	public void updateBook(Book a) throws Exception;
}
