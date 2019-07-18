
package com.bm.spring.dao;

import java.util.List;
import com.bm.spring.entity.Category;
public interface CategoryDAO {

	public void addCategory(Category a) throws Exception;

	public void editCategory(Category a) throws Exception;

	public void deleteCategory(int id) throws Exception;

	public List<Category> getCategoryList() throws Exception;

	public Category getCategoryById(int id) throws Exception;
}
