
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
import com.bm.spring.dao.CategoryDAO;
import com.bm.spring.entity.Category;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory _sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryList() throws Exception {

		Session session = this._sessionFactory.getCurrentSession();
		List<Category> CategoryList = session.createQuery("from " + Category.class.getName()).list();
		return CategoryList;
	}

	@Override
	public void addCategory(Category category) throws Exception {

		Session currentSession = _sessionFactory.getCurrentSession();
		currentSession.save(category);
	}

	@Override
	public void editCategory(Category Category) throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		session.update(Category);
	}

	@Override
	public void deleteCategory(int id) throws Exception {

		Session session = _sessionFactory.getCurrentSession();
		Category book = session.byId(Category.class).load(id);
		session.delete(book);
	}

	@Override
	public Category getCategoryById(int id) throws Exception {

		Session currentSession = _sessionFactory.getCurrentSession();
		Category category = currentSession.get(Category.class, id);
		return category;
	}
}
