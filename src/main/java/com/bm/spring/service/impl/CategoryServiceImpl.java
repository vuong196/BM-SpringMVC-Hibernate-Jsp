
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

	@Override
	@Transactional
	public void addCategory(Category a) throws Exception {

		_categoryDAO.addCategory(a);
	}

	@Override
	@Transactional
	public void deleteCategory(int id) throws Exception {

		_categoryDAO.deleteCategory(id);
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) throws Exception {

		return _categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public List<Category> getCategoryList() throws Exception {

		return _categoryDAO.getCategoryList();
	}

	@Override
	@Transactional
	public void updateCategory(Category a) throws Exception {

		_categoryDAO.updateCategory(a);
	}

	@Autowired
	private CategoryDAO _categoryDAO;
}
