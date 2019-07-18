
package com.bm.spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bm.spring.dao.CategoryDAO;
import com.bm.spring.entity.Category;
import com.bm.spring.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO _categoryDAO;

	@Override
	@Transactional
	public List<Category> getCategoryList() throws Exception {

		return this._categoryDAO.getCategoryList();
	}

	@Override
	@Transactional
	public void addCategory(Category a) throws Exception {

		this._categoryDAO.addCategory(a);
	}

	@Override
	@Transactional
	public void editCategory(Category a) throws Exception {

		this._categoryDAO.editCategory(a);
	}
	
	@Override
	@Transactional
	public void deleteCategory(int id) throws Exception {

		this._categoryDAO.deleteCategory(id);
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) throws Exception {

		return this._categoryDAO.getCategoryById(id);
	}
}
