
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
@Table(name = "book", catalog = "bookmanagement")
public class Book {

	public Book() {

	}

	public Author getBookAuthor() {

		return bookAuthor;
	}

	public Set<Category> getBookCategorySet() {

		return bookCategorySet;
	}

	public int getBookId() {

		return bookId;
	}

	public String getBookName() {

		return bookName;
	}

	public void setBookAuthor(Author bookAuthor) {

		this.bookAuthor = bookAuthor;
	}

	public void setBookCategorySet(Set<Category> bookCategorySet) {

		this.bookCategorySet = bookCategorySet;
	}

	public void setBookId(int bookId) {

		this.bookId = bookId;
	}

	public void setBookName(String bookName) {

		this.bookName = bookName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	private Author bookAuthor;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "book_category", catalog = "bookmanagement", joinColumns = {
		@JoinColumn(name = "book_id", nullable = false, updatable = false)
	}, inverseJoinColumns = {
		@JoinColumn(name = "category_id", nullable = false, updatable = false)
	})
	private Set<Category> bookCategorySet = new HashSet<>(0);

	@Column(name = "book_name", length = 50, nullable = false)
	private String bookName;
}
