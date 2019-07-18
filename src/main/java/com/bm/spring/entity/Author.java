
package com.bm.spring.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@Entity(name = "entity.Author")
@Table(name = "author", catalog = "bookmanagement")
public class Author {

	public Author() {

	}

	public int getAuthorId() {

		return authorId;
	}

	public String getAuthorName() {

		return authorName;
	}

	public Set<Book> getAuthorBookSet() {

		return authorBookSet;
	}

	public void setAuthorId(int authorId) {

		this.authorId = authorId;
	}

	public void setAuthorName(String authorName) {

		this.authorName = authorName;
	}

	public void setuthorBookSet(Set<Book> bookSet) {

		this.authorBookSet = bookSet;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int authorId;

	@Column(name = "author_name", length = 50, nullable = false)
	private String authorName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "_bookAuthor")
	private Set<Book> authorBookSet = new HashSet<>(0);
}
