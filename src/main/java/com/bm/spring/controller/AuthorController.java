
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
import com.bm.spring.entity.Author;
import com.bm.spring.service.AuthorService;
@Controller
@RequestMapping("/author")
public class AuthorController {

	@PostMapping("/add")
	public String addAuthor(@ModelAttribute("author") Author author) throws Exception {

		System.out.println(author.getAuthorName());
		_authorService.addAuthor(author);
		return "redirect:/author/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {

		_authorService.deleteAuthor(id);
		return "redirect:/author/list";
	}

	@PostMapping("/edit")
	public String editAuthor(@ModelAttribute("author") Author author) throws Exception {

		_authorService.editAuthor(author);
		return "redirect:/author/list";
	}

	@GetMapping("/list")
	public String getAuthorList(Model model) throws Exception {

		List<Author> authorList = _authorService.getAuthorList();
		model.addAttribute("authorList", authorList);
		return "author-list";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) throws Exception {

		Author author = new Author();
		System.out.println(author.getAuthorId());
		model.addAttribute("author", author);
		return "author-add";
	}

	@GetMapping("/editForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) throws Exception {

		Author author = _authorService.getAuthorById(id);
		model.addAttribute("author", author);
		return "author-edit";
	}
	

	@Autowired
	private AuthorService _authorService;
}
