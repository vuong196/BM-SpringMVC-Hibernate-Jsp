
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
import org.springframework.web.bind.annotation.RequestParam;
import com.bm.spring.model.Author;
import com.bm.spring.service.AuthorService;
@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired(required = true)
	private AuthorService _authorService;

	@Qualifier(value = "_authorService")
	public void setAuthorService(AuthorService authorService) {

		this._authorService = authorService;
	}

	@GetMapping("/list")
	public String getAuthorList(Model model) throws Exception {

		List<Author> authorList = this._authorService.getAuthorList();
		model.addAttribute("listAuthors", authorList);
		return "list-authors";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) throws Exception {

		Author author = new Author();
		model.addAttribute("customer", author);
		return "author-form";
	}

	@PostMapping("/save")
	public String saveAuthor(@ModelAttribute("author") Author author) throws Exception {

		this._authorService.addAuthor(author);
		return "redirect:/author/list";
	}

	@GetMapping("/editForm")
	public String showFormForUpdate(@RequestParam("id") String id, Model model) throws Exception {

		Author author = this._authorService.getAuthorById(id);
		model.addAttribute("author", author);
		return "author-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") String id) throws Exception {

		this._authorService.deleteAuthor(id);
		return "redirect:/author/list";
	}
}
