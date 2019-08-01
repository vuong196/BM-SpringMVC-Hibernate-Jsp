
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

	@Override
	@Transactional
	public void addBook(Book a) throws Exception {

		_bookDAO.addBook(a);
	}

	@Override
	@Transactional
	public void deleteBook(int id) throws Exception {

		_bookDAO.deleteBook(id);
	}

	@Override
	@Transactional
	public Book getBookById(int id) throws Exception {

		return _bookDAO.getBookById(id);
	}

	@Override
	@Transactional
	public List<Book> getBookList() throws Exception {

		return _bookDAO.getBookList();
	}

	@Override
	@Transactional
	public void updateBook(Book a) throws Exception {

		_bookDAO.updateBook(a);
	}

	@Autowired
	private BookDAO _bookDAO;
}
