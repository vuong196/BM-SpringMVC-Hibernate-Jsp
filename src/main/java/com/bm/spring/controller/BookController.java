
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
import com.bm.spring.entity.Book;
import com.bm.spring.entity.Category;
import com.bm.spring.service.AuthorService;
import com.bm.spring.service.BookService;
import com.bm.spring.service.CategoryService;
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService _bookService;

	@Autowired
	private CategoryService _categoryService;

	@Autowired
	private AuthorService _authorService;

	@GetMapping("/list")
	public String getBookList(Model model) throws Exception {

		List<Book> bookList = this._bookService.getBookList();
		List<Author> authorList = this._authorService.getAuthorList();
		List<Category> categoryList = this._categoryService.getCategoryList();
		model.addAttribute("bookList", bookList);
		model.addAttribute("authorList", authorList);
		model.addAttribute("categoryList", categoryList);
		return "book-list";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) throws Exception {

		List<Author> authorList = this._authorService.getAuthorList();
		List<Category> categoryList = this._categoryService.getCategoryList();
		Book book = new Book();
		model.addAttribute("authorList", authorList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("book", book);
		return "book-add";
	}

	@PostMapping("/add")
	public String addBook(@ModelAttribute("book") Book book) throws Exception {

		_bookService.addBook(book);
		return "redirect:/book/list";
	}

	@PostMapping("/update")
	public String updateBook(@ModelAttribute("book") Book book) throws Exception {

		_bookService.editBook(book);
		return "redirect:/book/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) throws Exception {

		List<Author> authorList = this._authorService.getAuthorList();
		List<Category> categoryList = this._categoryService.getCategoryList();
		Book book = this._bookService.getBookById(id);
		model.addAttribute("authorList", authorList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("book", book);
		return "book-edit";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {

		this._bookService.deleteBook(id);
		return "redirect:/book/list";
	}
}
