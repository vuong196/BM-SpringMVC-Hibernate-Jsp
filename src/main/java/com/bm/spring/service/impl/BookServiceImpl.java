
package com.bm.spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bm.spring.dao.BookDAO;
import com.bm.spring.entity.Book;
import com.bm.spring.service.BookService;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO _bookDAO;

	@Override
	@Transactional
	public List<Book> getBookList() throws Exception {

		return this._bookDAO.getBookList();
	}

	@Override
	@Transactional
	public void addBook(Book a) throws Exception {

		this._bookDAO.addBook(a);
	}

	@Override
	@Transactional
	public void editBook(Book a) throws Exception {

		this._bookDAO.editBook(a);
	}

	@Override
	@Transactional
	public void deleteBook(int id) throws Exception {

		this._bookDAO.deleteBook(id);
	}

	@Override
	@Transactional
	public Book getBookById(int id) throws Exception {

		return this._bookDAO.getBookById(id);
	}
}
