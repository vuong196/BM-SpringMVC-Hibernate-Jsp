
package com.bm.spring.dao;

import java.util.List;
import com.bm.spring.entity.Book;
public interface BookDAO {

	public void addBook(Book a) throws Exception;

	public void editBook(Book a) throws Exception;

	public void deleteBook(int id) throws Exception;

	public List<Book> getBookList() throws Exception;

	public Book getBookById(int id) throws Exception;
}
