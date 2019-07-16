
package com.bm.spring.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bm.spring.dao.AuthorDAO;
import com.bm.spring.model.Author;
@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory _sessionFactory;

	@Override
	public List<Author> getAuthorList() throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		List<Author> authorList = session.createQuery("from " + Author.class.getName()).list();
		return authorList;
	}

	@Override
	public void addAuthor(Author a) throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		session.persist(a);
	}

	@Override
	public void editAuthor(Author a) throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		session.update(a);
	}

	@Override
	public void deleteAuthor(String id) throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		Author a = session.load(Author.class, new Integer(id));
		if (null != a) {
			session.delete(a);
		}
	}

	@Override
	public Author getAuthorById(String id) throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		Author a = session.load(Author.class, new Integer(id));
		return a;
	}
}
