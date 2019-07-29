
package com.bm.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity(name = "entity.Author")
@Table(name = "author", catalog = "bookmanagement")
public class Author {

	public Author() {
	}

	public Set<Book> getAuthorBookSet() {

		return _authorBookSet;
	}

	public int getAuthorId() {

		return _authorId;
	}

	public String getAuthorName() {

		return _authorName;
	}

	public void setAuthorBookSet(Set<Book> bookSet) {

		_authorBookSet = bookSet;
	}

	public void setAuthorId(int authorId) {

		_authorId = authorId;
	}

	public void setAuthorName(String authorName) {

		_authorName = authorName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_bookAuthor")
	private Set<Book> _authorBookSet = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int _authorId;

	@Column(name = "author_name", length = 50, nullable = false)
	private String _authorName;
}
