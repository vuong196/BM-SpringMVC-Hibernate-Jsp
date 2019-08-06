
package com.bm.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity(name = "entity.Book")
@Table(name = "book", catalog = "dckkgcufb23jta")
public class Book {

	public Book() {
	}

	public int getBookId() {

		return _bookId;
	}

	public Author getBookAuthor() {

		return _bookAuthor;
	}

	public Set<Category> getBookCategorySet() {

		return _bookCategorySet;
	}

	public String getBookName() {

		return _bookName;
	}

	public void setBookAuthor(Author bookAuthor) {

		_bookAuthor = bookAuthor;
	}

	public void setBookCategorySet(Set<Category> bookCategorySet) {

		_bookCategorySet = bookCategorySet;
	}

	public void setBookId(int bookId) {

		_bookId = bookId;
	}

	public void setBookName(String bookName) {

		_bookName = bookName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", nullable = false)
	private Author _bookAuthor;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "book_category", catalog = "bookmanagement", joinColumns = {
		@JoinColumn(name = "book_id", nullable = false, updatable = false)
	}, inverseJoinColumns = {
		@JoinColumn(name = "category_id", nullable = false, updatable = false)
	})
	private Set<Category> _bookCategorySet = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int _bookId;

	@Column(name = "book_name", length = 50, nullable = false)
	private String _bookName;
}
