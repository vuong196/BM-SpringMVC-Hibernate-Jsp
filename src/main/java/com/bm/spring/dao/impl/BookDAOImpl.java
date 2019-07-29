
package com.bm.spring.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bm.spring.dao.BookDAO;
import com.bm.spring.entity.Book;
public class BookDAOImpl implements BookDAO {

	@Override
	public void addBook(Book Book) throws Exception {

		Session currentSession = _sessionFactory.getCurrentSession();
		currentSession.save(Book);
	}

	@Override
	public void deleteBook(int id) throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);
	}

	@Override
	public void editBook(Book Book) throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		session.update(Book);
	}

	@Override
	public Book getBookById(int id) throws Exception {

		Session currentSession = _sessionFactory.getCurrentSession();
		Book Book = currentSession.get(Book.class, id);
		return Book;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookList() throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		List<Book> BookList = session.createQuery("from " + Book.class.getName()).list();
		return BookList;
	}

	@Autowired
	private SessionFactory _sessionFactory;
}
