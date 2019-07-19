
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

	public int getAuthorId() {

		return _authorId;
	}

	public String getAuthorName() {

		return _authorName;
	}

	public Set<Book> getAuthorBookSet() {

		return _authorBookSet;
	}

	public void setAuthorId(int authorId) {

		this._authorId = authorId;
	}

	public void setAuthorName(String authorName) {

		this._authorName = authorName;
	}

	public void setAuthorBookSet(Set<Book> bookSet) {

		this._authorBookSet = bookSet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int _authorId;

	@Column(name = "author_name", length = 50, nullable = false)
	private String _authorName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_bookAuthor")
	private Set<Book> _authorBookSet = new HashSet<>(0);
}
