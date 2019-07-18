
package com.bm.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bm.spring.entity.Category;
import com.bm.spring.service.CategoryService;
@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService _categoryService;
	
	@GetMapping("/list")
	public String getCategoryList(Model model) throws Exception {

		List<Category> categoryList = this._categoryService.getCategoryList();
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

	@PostMapping("/add")
	public String addCategory(@ModelAttribute("category") Category category) throws Exception {
		
		System.out.println(category.getCategoryName());
		_categoryService.addCategory(category);
		return "redirect:/category/list";
	}
	
	@PostMapping("/edit")
	public String editCategory(@ModelAttribute("category") Category category) throws Exception {
		
		_categoryService.editCategory(category);
		return "redirect:/category/list";
	}

	@GetMapping("/editForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) throws Exception {

		Category category = this._categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "Category-edit";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {

		this._categoryService.deleteCategory(id);
		return "redirect:/Category/list";
	}
}
