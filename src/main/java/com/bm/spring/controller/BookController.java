
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

	@PostMapping("/add/save")
	public String addBook(@ModelAttribute("book") Book book) throws Exception {

		_bookService.addBook(book);
		return "redirect:/book/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) throws Exception {

		_bookService.deleteBook(id);
		return "redirect:/book/list";
	}

	@GetMapping({"/list" , ""})
	public String getBookList(Model model) throws Exception {

		List<Book> bookList = _bookService.getBookList();
		List<Author> authorList = _authorService.getAuthorList();
		List<Category> categoryList = _categoryService.getCategoryList();
		model.addAttribute("bookList", bookList);
		model.addAttribute("authorList", authorList);
		model.addAttribute("categoryList", categoryList);
		return "book-list";
	}

	@PostMapping("/update/save")
	public String updateBook(@ModelAttribute("book") Book book) throws Exception {

		_bookService.updateBook(book);
		return "redirect:/book/list";
	}
	
	@GetMapping("/add/form")
	public String showFormForAdd(Model model) throws Exception {

		List<Author> authorList = _authorService.getAuthorList();
		List<Category> categoryList = _categoryService.getCategoryList();
		Book book = new Book();
		model.addAttribute("authorList", authorList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("book", book);
		return "book-add";
	}

	@GetMapping("/update/form")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) throws Exception {

		List<Author> authorList = _authorService.getAuthorList();
		List<Category> categoryList = _categoryService.getCategoryList();
		Book book = _bookService.getBookById(id);
		model.addAttribute("authorList", authorList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("book", book);
		return "book-edit";
	}
	
	@ModelAttribute("authors")
	public List<Author> initializeAuthors() throws Exception {
		return _authorService.getAuthorList();
	}
	
	@Autowired
	private AuthorService _authorService;

	@Autowired
	private BookService _bookService;

	@Autowired
	private CategoryService _categoryService;
}
