
package com.bm.spring.dao.impl;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bm.spring.dao.AuthorDAO;
import com.bm.spring.entity.Author;
@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory _sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAuthorList() throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		List<Author> authorList = session.createQuery("from " + Author.class.getName()).list();
		return authorList;
	}

	@Override
	public void addAuthor(Author author) throws Exception {

		Session currentSession = _sessionFactory.getCurrentSession();
		currentSession.save(author);
	}

	@Override
	public void editAuthor(Author author) throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		session.update(author);
	}

	@Override
	public void deleteAuthor(int id) throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		Author book = session.byId(Author.class).load(id);
		session.delete(book);
	}

	@Override
	public Author getAuthorById(int id) throws Exception {

		Session currentSession = _sessionFactory.getCurrentSession();
		Author author = currentSession.get(Author.class, id);
		return author;
	}
}
