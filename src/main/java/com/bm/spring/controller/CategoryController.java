
package com.bm.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bm.spring.entity.Category;
import com.bm.spring.service.CategoryService;
@Controller
@RequestMapping("/category")
public class CategoryController {

	@PostMapping("/add")
	public String addCategory(@ModelAttribute("category") Category category) throws Exception {

		System.out.println(category.getCategoryName());
		_categoryService.addCategory(category);
		return "redirect:/category/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {

		_categoryService.deleteCategory(id);
		return "redirect:/Category/list";
	}

	@PostMapping("/edit")
	public String editCategory(@ModelAttribute("category") Category category) throws Exception {

		_categoryService.editCategory(category);
		return "redirect:/category/list";
	}

	@GetMapping("/list")
	public String getCategoryList(Model model) throws Exception {

		List<Category> categoryList = _categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "category-list";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) throws Exception {

		Category category = new Category();
		System.out.println(category.getCategoryId());
		model.addAttribute("category", category);
		return "category-add";
	}

	@GetMapping("/editForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) throws Exception {

		Category category = _categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "Category-edit";
	}

	@Autowired
	private CategoryService _categoryService;
}
