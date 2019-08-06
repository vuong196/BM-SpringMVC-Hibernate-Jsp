
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

	@PostMapping("/add/save")
	public String addCategory(@ModelAttribute("category") Category category) throws Exception {

		_categoryService.addCategory(category);
		return "redirect:/category/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {

		_categoryService.deleteCategory(id);
		return "redirect:/category/list";
	}

	@PostMapping("/update/save")
	public String updateCategory(@ModelAttribute("category") Category category) throws Exception {

		_categoryService.updateCategory(category);
		return "redirect:/category/list";
	}

	@GetMapping({"/list" , ""})
	public String getCategoryList(Model model) throws Exception {

		List<Category> categoryList = _categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "category-list";
	}

	@GetMapping("/add/form")
	public String showFormForAdd(Model model) throws Exception {

		Category category = new Category();
		model.addAttribute("category", category);
		return "category-add";
	}

	@GetMapping("/update/form")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) throws Exception {

		Category category = _categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "category-edit";
	}

	@Autowired
	private CategoryService _categoryService;
}
