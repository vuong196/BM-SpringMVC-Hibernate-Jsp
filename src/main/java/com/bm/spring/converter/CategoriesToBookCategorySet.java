
package com.bm.spring.converter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bm.spring.entity.Category;
import com.bm.spring.service.CategoryService;

@Component
public class CategoriesToBookCategorySet implements Converter<String[], Set<Category>> {
	
	@Autowired
	private CategoryService _categoryService;

	@Override
	public Set<Category> convert(String[] arg0) {
		
		List<String> list = Arrays.asList((String[])arg0);
		
		Set<Category> categorySet = new HashSet<>(0);
		for (Object e : list) {
			try {
				categorySet.add(_categoryService.getCategoryById(Integer.parseInt((String) e)));
			}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return categorySet;
	}
	
}
